package cn.mcmod.tea_sorcerer.util;

import net.minecraft.nbt.CompoundNBT;

public abstract class TagPropertyAccessor<T extends Comparable<?>> {
    protected final String tagName;
    public TagPropertyAccessor(String tagName){
        this.tagName = tagName;
    }

    public boolean exists(CompoundNBT tag){
        return tag.contains(this.tagName);
    }

    public void remove(CompoundNBT tag){
        if(exists(tag))
            tag.remove(this.tagName);
    }

    abstract public T get(CompoundNBT tag);
    public T get(CompoundNBT tag, T defaultValue){
        return this.exists(tag) ? get(tag) : defaultValue;
    }
    abstract public T set(CompoundNBT tag, T value);

    static public class TagPropertyString extends TagPropertyAccessor<String>{

        public TagPropertyString(String tagName) {
            super(tagName);
        }

        @Override
        public String get(CompoundNBT tag) {
            return tag.getString(this.tagName);
        }

        @Override
        public String set(CompoundNBT tag, String value) {
            tag.putString(this.tagName,value);
            return value;
        }
    }

    static public class TagPropertyBoolean extends TagPropertyAccessor<Boolean>{
        public TagPropertyBoolean(String tagName){
            super(tagName);
        }

        @Override
        public Boolean get(CompoundNBT tag){
            return tag.getBoolean(this.tagName);
        }

        @Override
        public Boolean set(CompoundNBT tag, Boolean value) {
            tag.putBoolean(this.tagName, value);
            return value;
        }

        public Boolean invert(CompoundNBT tag){
            return set(tag,!get(tag));
        }
    }

    static public class TagPropertyLong extends TagPropertyAccessor<Long>{
        public TagPropertyLong(String tagName){
            super(tagName);
        }

        @Override
        public Long get(CompoundNBT tag){
            return tag.getLong(this.tagName);
        }

        @Override
        public Long set(CompoundNBT tag, Long value) {
            tag.putLong(this.tagName, value);
            return value;
        }

        public Long add(CompoundNBT tag, Long value) {
            Long result = get(tag) + value;
            return this.set(tag, result);
        }
    }

    static public class TagPropertyInteger extends TagPropertyAccessor<Integer>{
        public TagPropertyInteger(String tagName){
            super(tagName);
        }

        @Override
        public Integer get(CompoundNBT tag){
            return tag.getInt(this.tagName);
        }

        @Override
        public Integer set(CompoundNBT tag, Integer value) {
            tag.putInt(this.tagName, value);
            return value;
        }

        public Integer add(CompoundNBT tag, Integer value) {
            Integer result = get(tag) + value;
            return this.set(tag,result);
        }
    }

    static public class TagPropertyIntegerWithRange extends TagPropertyInteger{
        private int min;
        private int max;
        public TagPropertyIntegerWithRange(String tagName, int min, int max) {
            super(tagName);
            this.min = min;
            this.max = max;
        }

        @Override
        public Integer set(CompoundNBT tag, Integer value) {
            if(value < min)
                value = min;
            else if(max < value)
                value = max;
            return super.set(tag, value);
        }

        public boolean tryAdd(CompoundNBT tag, Integer add, boolean forceAdd){
            int value = get(tag);

            value = value + add;

            boolean doSet = forceAdd || (min <= value && value <= max);

            if(doSet){
                set(tag,value);
            }

            return doSet;
        }
    }

    static public class TagPropertyFloat extends TagPropertyAccessor<Float>{
        public TagPropertyFloat(String tagName){
            super(tagName);
        }

        @Override
        public Float get(CompoundNBT tag){
            return tag.getFloat(this.tagName);
        }

        @Override
        public Float set(CompoundNBT tag, Float value) {
            tag.putFloat(this.tagName, value);
            return value;
        }

        public float get(CompoundNBT tag,float defaultValue){
            return tag.contains(this.tagName) ? tag.getFloat(this.tagName) : defaultValue;
        }
    }
}

package cn.yiwang.ctp.struct;

import java.lang.reflect.Field;

public class CTPField {

    public String getString(String str) {
        if (str != null) {
            return str;
        } else {
            return "null";
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        Field[] fields = this.getClass().getDeclaredFields();
        if (fields != null) {
            for ( int i = 0; i< fields.length; i++) {
            	Field f = fields[i];
                try {
                    sb.append(f.getName());
                    sb.append(":");
                    Object obj = f.get(this);
                    if (obj == null) {
                        sb.append("null");
                    } else {
                        sb.append(obj.toString());
                    }
                    sb.append(",");
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }
            }
        }
        return sb.toString();
    }

    public String toCSVTitleString() {
        StringBuffer sb = new StringBuffer();

        Field[] fields = this.getClass().getDeclaredFields();
        if (fields != null) {
            for ( int i = 0; i< fields.length; i++) {
            	Field f = fields[i];
                try {
                    sb.append(f.getName());
                    sb.append(",");
                } catch (IllegalArgumentException e) {
                }
            }
        }
        return sb.toString();
    }

    public String toCSVString() {
        StringBuffer sb = new StringBuffer();

        Field[] fields = this.getClass().getDeclaredFields();
        if (fields != null) {
            for ( int i = 0; i< fields.length; i++) {
            	Field f = fields[i];
                try {
                    Object obj = f.get(this);
                    if (obj == null) {
                        sb.append("null");
                    } else {
                        sb.append(obj.toString());
                    }
                    sb.append(",");
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                }
            }
        }
        return sb.toString();
    }
}

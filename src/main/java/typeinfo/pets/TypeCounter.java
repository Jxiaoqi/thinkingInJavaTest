package typeinfo.pets;

import java.util.HashMap;

/**
 * obj.isAssignableFrom(Class<?> cls) 方法，用来判断cls 是否在obj类型的继承结构上
 * 即：cls 是否是obj的扩展累或者接口
 *
 * @author xiaoqi
 * @since 28 八月 2018
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?> baseType;

    /**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public TypeCounter (Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count (Object obj) {
        Class type = obj.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: "
                    + type + ", should be type or subtype of "
                    + baseType);
        }
        countClass(type);
    }

    public void countClass(Class<?> type) {
        Integer quantity = get(type);
        if (baseType.isAssignableFrom(type)) {
            put(type, quantity == null ? 1 : quantity + 1);
        }
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Entry<Class<?>, Integer> entry : entrySet()) {
            sb.append(entry.getKey().getSimpleName())
                    .append(" = ")
                    .append(entry.getValue())
                    .append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }
}

package com.book.java8feature.Chapter6;

import com.book.java8feature.Chapter4.CaloricLevel;
import com.book.java8feature.Chapter4.Dish;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupTest {

    public static void main (String[] args) {
        List<Dish> menu = Dish.menu;

        //把菜单中的菜按照类型分类  Collectors.groupingBy()
        Map<Dish.Type, List<Dish>> dishesByType =
                                    menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        // 分类函数不一定像方法引用那样可用，因为你想用以分类的条件可能比简单的属性访问器要复杂
        //把菜单中的菜按照能量级别分组
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return  CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
        );
        System.out.println(dishesByCaloricLevel);

        //多级分组  把菜单中的菜品按照类别和能量分组
        //要实现多级分组，可以使用一个由双参版本的Collectors.groupingBy()工厂方法创建的收集器，它除了普通的分类函数外，
        //还可以接受一个Collector类型的第二个参数。
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                  groupingBy(Dish::getType,
                          groupingBy((Dish dish) -> {
                              if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                              else if (dish.getCalories() <= 700) return  CaloricLevel.NORMAL;
                              else return CaloricLevel.FAT;
                          }))
                );
        System.out.println(dishesByTypeCaloricLevel);
        
    //按子组收集数据
        //传递给第一个groupBy的第二个收集器可以是任何类型，而不一定是另一个groupingBy
        //数一数菜单中每类菜有多少个
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting())
        );
        System.out.println(typesCount);

        //查找菜单中每类菜中能量最高的菜
        //这个Map中的值是Optional，因为这是maxBy工厂方法生成的收集器类型，但实际上，如果菜单中没有某一个类型的
        //dish,这个类型就不会对应一个Option.empty()值，而且根本不会出现在Map的键中。Optional包装器在这里不是很有用。
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                    .collect(groupingBy(Dish::getType,
                            maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        //Collectors.collectiongAndThen(),这个工厂方法接受两个参数---要转换的收集器已经转换函数，返回另一个收集器
        // Optional::get 在这里是安全的，因为reducing 收集器永远不会返回Option.empty()
        Map<Dish.Type, Dish> mostCaloricByType1 =
                menu.stream()
                    .collect(groupingBy(Dish::getType,
                            collectingAndThen(
                                    maxBy(Comparator.comparingInt(Dish::getCalories)),
                                    Optional::get
                            )));
        System.out.println(mostCaloricByType1);

        // 通过groupingBy 工厂方法的第二个参数传递的收集器会对分到同一组的所有流元素执行进一步规约操作。
        //求出每一种类型的菜的热量总和
        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        //常常和groupingBy联合使用的另一个收集器是mapping方法生成的。 mapping方法接受两个参数： 一个对流中的元素做变化，另一个则
        //将变换的结果对象收集起来。目的： 在累加之前对每个输入元素应用一个映射函数，这样就可以让接受特定类型元素的收集器使用不同类型的对象。
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                                },
                                toSet()
                        ))
                );
        System.out.println(caloricLevelsByType);

        //在上一个示例中，对于返回的Set是什么类型并没有什么保证。但是通过toCollection(),你就可以有更多的控制，
        //例如，可以给它传递一个构造函数引用来要求HashSet
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType1 =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400)  { return CaloricLevel.DIET;}
                            else if (dish.getCalories() <= 700)  {return CaloricLevel.NORMAL;}
                            else {return CaloricLevel.FAT;}
                        }, toCollection(HashSet::new)))
                );
        System.out.println(caloricLevelsByType1);
    }
}

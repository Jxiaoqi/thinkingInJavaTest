package util;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.SystemOutLogger;
import sun.tools.tree.DoubleExpression;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {
    
    public Test() {
        System.out.println("Test()");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }
    
    
    public static void main(String[] args) {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5, new ThreadFactoryBuilder().setNameFormat("activity-scheduled-task-%d").setDaemon(true).build());
//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            System.out.println("11111");
//        }, 0, 10, TimeUnit.SECONDS);
    
        LocalDateTime now = LocalDateTime.now();
        now.compareTo(now);
        List<Double> list = Lists.newArrayList(2.1d, 2.3d, 1.2d, 3.6d);
        list.sort(Comparator.comparing(x -> x.longValue()));
    }
    
    
    /**
     * 根据性别是否推荐
     *
     * @param requestSex 请求的sex
     * @param ownerSex 房主的sex
     * @param needSex 请求想要的sex
     * @return
     */
    public static boolean isRecommendBySexV2(String requestSex, String needSex, String ownerSex) {
        if(StringUtils.isEmpty(ownerSex) || StringUtils.isEmpty(requestSex)) {
            return false;
        }
        String requestSexTemp = requestSex.toUpperCase();
        String ownerSexTemp = ownerSex.toUpperCase();
        String needSexTemp = "";
        String recommendSex = recommendF;
        if (StringUtils.isNotEmpty(needSex)) {
            needSexTemp = needSex.toUpperCase();
        }
        if ("M".equals(requestSexTemp)) {
            recommendSex = recommendM;
        }
        if (StringUtils.isNotEmpty(needSexTemp) && needSexTemp.indexOf(ownerSexTemp) > -1) {
            return true;
        }
        if (recommendSex.indexOf(ownerSexTemp) > -1) {
            return true;
        }
        return false;
    }
    
    
    /** M - 性别推荐 */
    public static String recommendM = "F";
    /** F - 性别推荐 */
    public static String recommendF = "M";
}

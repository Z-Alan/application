package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 使用Java8的时间api 进行时间互相转换，格式化，计算
 *
 * @author zhouqiang
 */
public class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);


    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";


    /**
     * formatInstantToLocalDateTime.
     *
     * @param instant 时间戳字符串 1354838400
     * @return 转换后的标准localDateTime eg. 2018-06-21T18:01:04
     * @author zhouqiang
     */
    public static LocalDateTime formatInstantToLocalDateTime(String instant, String ofPattern) {
        LOGGER.info("[- 参数 -] --- [- {} -]", instant);
        long timestamp = Long.parseLong(instant);
        LOGGER.info("[- 临时变量 -] 时间戳String转换long类型 --- [- {} -]", timestamp);
        DateTimeFormatter df = DateTimeFormatter.ofPattern(ofPattern);
        String timeTarget = df.format(LocalDateTime
                .ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("Asia/Shanghai")));
        LOGGER.info("[- 格式时间 -] 规范格式 --- [- {} -]", timeTarget);
        return LocalDateTime.parse(timeTarget, df);
    }
    public static void main(String[] args) {

        LocalDateTime dateTime = DateUtil.formatInstantToLocalDateTime("1354838400", DATE_TIME);

        LOGGER.info("[- 结果 -] 时间戳转LocalDateTime --- [- {} -]", dateTime);
    }

}

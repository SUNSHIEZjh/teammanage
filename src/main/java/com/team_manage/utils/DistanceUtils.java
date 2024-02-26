package com.team_manage.utils;

/**
 * 经纬度距离计算
 *
 * @author XXX
 * @since 2023-12-01
 */
public class DistanceUtils {

    // 地球半径，单位为米
    private static final double EARTH_RADIUS = 6371000.0;

    /**
     * 计算两个经纬度之间的距离，使用 Vincenty 公式计算，精度较高。
     *
     * @param lat1 第一个点的纬度，单位为度
     * @param lon1 第一个点的经度，单位为度
     * @param lat2 第二个点的纬度，单位为度
     * @param lon2 第二个点的经度，单位为度
     * @return 两个经纬度之间的距离，单位为米
     */
    public static double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        // 将经度差转换为弧度
        double lonDiff = Math.toRadians(lon2 - lon1);

        // 计算公式中的参数
        double a = Math.pow(Math.cos(Math.toRadians(lat2)) * Math.sin(lonDiff), 2)
                + Math.pow(Math.cos(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
                        - Math.sin(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(lonDiff),
                2);
        double b = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(lonDiff);

        // 计算角度，单位为弧度
        double angle = Math.atan2(Math.sqrt(a), b);

        // 计算距离，单位为米
        return angle * EARTH_RADIUS;
    }
}

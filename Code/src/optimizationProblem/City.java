package optimizationProblem;

public class City {
    // �������뾶
    private static final double ERATH_EQUATORIAL_RADIUS = 6378.1370D;
    
    private static final double CONCVERT_DEGREES_TO_RADIANS = Math.PI / 180;
    // ����
    private double longitude;
    // γ��
    private double latitude;
    // ������
    private String name;
    
    public City(double longitude, double latitude, String name) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }
    
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
    
    /**
     * ���㴫������뵱ǰ���е�ʵ�ʾ���
     * @param city
     * @return
     */
    public double measureDistance(City city) {
        double deltaLongitude = deg2rad(city.getLongitude() - this.getLongitude());
        double deltaLatitude = deg2rad(city.getLatitude() - this.getLatitude());
        double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) 
                + Math.cos(deg2rad(this.getLatitude())) 
                * Math.cos(deg2rad(city.getLatitude())) 
                * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
        return  ERATH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
    }
    
    // ת��Ϊ����
    private double deg2rad(double deg) {
          return deg * CONCVERT_DEGREES_TO_RADIANS;
    }
}

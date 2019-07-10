import org.junit.jupiter.api.Test;
import util.EnumUtil;

import java.util.Map;

class EnumUtilTest {

    @Test
    void getEnumMap() {
        Map<String, StatusEnum> map = EnumUtil.getEnumMap(StatusEnum.class);
        for (StatusEnum statusEnum :
                map.values()) {
            System.out.println(statusEnum.name());
            System.out.println(statusEnum.toString());
        }
    }
}
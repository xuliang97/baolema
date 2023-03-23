package com.cook.baolema;

import com.cook.baolema.dao.CategoryDao;
import com.cook.baolema.dao.OrderInfoDao;
import com.cook.baolema.respdata.HourAndOrderNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BaolemaApplicationTests {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private OrderInfoDao orderInfoDao;
    @Test
    void contextLoads() {
        List<HourAndOrderNumber> hourAndOrderNumbers = orderInfoDao.selectOrderOfHour();
        System.out.println(hourAndOrderNumbers);
    }



    public int compare(String version1, String version2) {
        // write code here
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        int n1 = -1;
        int n2 = -1;

        int lenMax = Math.max(v1.length, v2.length);
        for (int i = 0; i < lenMax; i++) {
            if (i >= v1.length) {
                n1 = 0;
                n2 = Integer.parseInt(v2[i]);
            } else if (i >= v2.length) {
                n2 = 0;
                n1 = Integer.parseInt(v1[i]);
            } else {
                n1 = Integer.parseInt(v1[i]);
                n2 = Integer.parseInt(v2[i]);
            }
            if (n1 < n2) {
                return -1;
            }
            if (n1 > n2) {
                return 1;
            }
        }
        return 0;
    }


}

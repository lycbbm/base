package com.tencent.bbm;

import com.tencent.bbm.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.service.ApiListing;

import javax.sound.midi.Soundbank;

@SpringBootTest
class BbmApplicationTests {

    RedisTemplate<String, String> redisTemplate  = new RedisTemplate<>();

    @Test
    void contextLoads() {
    }

    @Test
    void  test(){
        redisTemplate.opsForValue().set("bbm", "bbm");
        String bbm = redisTemplate.opsForValue().get("bbm");
        System.out.println(bbm);
    }

}

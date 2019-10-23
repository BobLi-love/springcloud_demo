package com.controller;

import com.client.PeopleClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "fail")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    // 第一种
//    @Autowired
//    DiscoveryClient discoveryClient;

    // 第二种
//    @Autowired
//    RibbonLoadBalancerClient client;

    @GetMapping("{id}")
    public People getObject(@PathVariable("id") Integer id) {
        // 第一种
//        List<ServiceInstance> instances = discoveryClient.getInstances("people-service");
//        ServiceInstance instance = instances.get(0);
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/people/" + id;

//        String url = "http://localhost:8081/people/" + id;

        // 第二种
//        ServiceInstance instance = client.choose("people-service"); 默认轮询
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/people/" + id;
        String url = "http://people-service/people/" + id;
        People people = restTemplate.getForObject(url, People.class);
        return people;
    }

    @GetMapping("/hystrix/{id}")
//    @HystrixCommand(fallbackMethod = "fail")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String getPeople(@PathVariable("id") Integer id) {
        if (id % 2 == 0) {
            throw new RuntimeException("失败");
        }
        String url = "http://people-service/people/" + id;
        String people = restTemplate.getForObject(url, String.class);
        return people;
    }

    public String fail() {
        return "哦呦，服务器开小差了!";
    }

//    @Autowired
//    PeopleClient peopleClient;
//    // feign的应用
//    @GetMapping("/feign/{id}")
//    public People getById(@PathVariable("id") Integer id) {
//        return peopleClient.getById(id);
//    }
}

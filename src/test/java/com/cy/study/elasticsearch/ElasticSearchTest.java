//package com.cy.study.elasticsearch;
//
//import com.cy.study.elasticsearch.dao.PagingAndSortingRepository;
//import com.cy.study.elasticsearch.dao.UserRepository;
//import com.cy.study.elasticsearch.model.User;
//import com.cy.study.elasticsearch.service.BaseElasticService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * elasticsearch单元测试
// *
// * @author cy
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ElasticSearchTest {
//
//
//    @Autowired
//    BaseElasticService baseElasticService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PagingAndSortingRepository pagingAndSortingRepository;
//
//    /**
//     * 分页查询
//     */
//    @Test
//    public void pagingFind(){
//        Page page = pagingAndSortingRepository.findAll(PageRequest.of(0, 2));
//        System.out.println("总页数："+page.getTotalPages()+";总条数："+page.getTotalElements());
//        List<User> users = page.getContent();
//        users.forEach(user -> System.out.println(user.toString()));
//    }
//
//    /**
//     * 排序查询
//     */
//    @Test
//    public void sortFind(){
//        Sort sort = Sort.by("age").descending();
//        Iterable<User> all = pagingAndSortingRepository.findAll(sort);
//        all.forEach(x-> System.out.println(x.toString()));
//    }
//
//
//    @Test
//    public void getOne(){
//        User user = baseElasticService.findById(1l);
//        System.out.println(user.toString());
//    }
//
//    /**
//     * 根据条件查询
//     */
//    @Test
//    public void getOneByCondition(){
//        List<User> users = userRepository.findByUsernameAndAge("xy", 25);
//        System.out.println(users.size());
//    }
//
//    /**
//     * 查询所有
//     */
//    @Test
//    public void findAll(){
//        Iterable<User> all = userRepository.findAll();
//        all.forEach(x-> System.out.println(x.toString()));
//    }
//
//    /**
//     * 新增
//     */
//    @Test
//    public void save(){
//        User user = new User();
//        user.setSex("女");
//        user.setPassword("1111");
//        user.setAge(18);
//        user.setUsername("lxy");
//        userRepository.save(user);
//    }
//
//    /**
//     * 根据ID查询
//     */
//    @Test
//    public void findById(){
//        Optional<User> optional = userRepository.findById("2");
//        System.out.println(optional.get().toString());
//    }
//
//    /**
//     * 根据ID删除
//     */
//    @Test
//    public void deleteById(){
//        userRepository.deleteById("dWWzRXIBTFDptJMYPpiE");
//    }
//
//    /**
//     * 判断ID是否存在
//     */
//    @Test
//    public void exitsById(){
//        boolean existsById = userRepository.existsById("dWWzRXIBTFDptJMYPpiE");
//        System.out.println(existsById);
//    }
//
//
//}

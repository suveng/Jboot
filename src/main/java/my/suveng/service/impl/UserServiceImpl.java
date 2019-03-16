package my.suveng.service.impl;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.CacheEvict;
import io.jboot.core.cache.annotation.Cacheable;
import my.suveng.service.UserService;
import my.suveng.model.User;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class UserServiceImpl extends JbootServiceBase<User> implements UserService {
    @Override
    @Cacheable(name = "myCache",key = "page:#(page)-#(size)")
    public Page<User> paginate(int page, int size) {
        return DAO.paginate(page, size);
    }

    /**
     * 保存到数据库
     *
     * @param model
     *
     * @return
     */
    @Override
    @CacheEvict(name = "myCache",key = "*")
    public boolean save(User model) {
        return super.save(model);
    }
}

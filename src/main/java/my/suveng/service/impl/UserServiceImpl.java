package my.suveng.service.impl;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.aop.annotation.Bean;
import my.suveng.service.UserService;
import my.suveng.model.User;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class UserServiceImpl extends JbootServiceBase<User> implements UserService {
    @Override
    public Page<User> paginate(int page, int size) {
        return DAO.paginate(page, size);
    }
}

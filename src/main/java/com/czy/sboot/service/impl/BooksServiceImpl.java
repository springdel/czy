package com.czy.sboot.service.impl;

import com.czy.sboot.entity.Books;
import com.czy.sboot.mapper.BooksMapper;
import com.czy.sboot.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-03-09
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

}

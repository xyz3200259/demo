/*
 * Copyright (c) 2018-present the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.huafi.demo.web;

import com.huafi.demo.BaseTest;
import com.huafi.demo.entity.User;
import com.huafi.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @since 1.0
 */
public class RepositoryTest extends BaseTest {

	@Autowired
	private UserRepository userRepository;


	@Test
	public void testSave() {
		User user=new User();
		user.setFirstName("x");
		user.setLastName("yz");
		User saveUser=userRepository.save(user);
		Assert.assertTrue(saveUser!=null);
	}
	@Test
	public void testfindBy(){
		User user=new User();
		user.setFirstName("x");
		user.setLastName("yz");
		User saveUser=userRepository.save(user);
		Assert.assertTrue(saveUser!=null);
		List<User> results=userRepository.findByLastName("yz");
		Assert.assertTrue(results.size()>0);
	}
	@Test
	public void testfindByPage(){
		User user=new User();
		user.setFirstName("x");
		user.setLastName("yz");
		User saveUser=userRepository.save(user);
		Assert.assertTrue(saveUser!=null);
		Pageable pageable= PageRequest.of(0,10);
		Page<User> results=userRepository.findAll(pageable);
		Assert.assertTrue(results.getSize()>0);
	}
	@Test
	public void testfindByCustomize(){
		User user=new User();
		user.setFirstName("x");
		user.setLastName("yz");
		User saveUser=userRepository.save(user);
		List<User> users = userRepository.findUseMapper("yz");
		Assert.assertTrue(users.size()>0);
	}
}

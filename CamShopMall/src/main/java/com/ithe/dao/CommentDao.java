package com.ithe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithe.entity.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

}

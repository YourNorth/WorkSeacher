package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.Blog;
import com.tenere_bufo.itis.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}

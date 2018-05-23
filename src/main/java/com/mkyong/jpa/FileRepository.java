package com.mkyong.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.entity.FileModel;

public interface FileRepository extends JpaRepository<FileModel, Long> {

}

package io.javaheart.makeiteasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javaheart.makeiteasy.model.SecurityQuestion;

public interface SecurityQuestionRepo extends JpaRepository<SecurityQuestion, String> {

}

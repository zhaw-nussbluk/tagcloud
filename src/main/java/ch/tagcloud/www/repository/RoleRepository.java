package ch.tagcloud.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.tagcloud.www.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
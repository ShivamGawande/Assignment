/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.repo;

import com.login.entity.TeamLeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TLeaderRepo extends JpaRepository<TeamLeader,Integer> {
}

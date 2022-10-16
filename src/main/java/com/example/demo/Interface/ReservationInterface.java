/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Interface;

import com.example.demo.Modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author casa2023
 */
public interface ReservationInterface extends CrudRepository <Reservation, Integer>{ /*tipo de dato de la llave*/
    
    public List<Reservation> findAllByStatus (String status); /*estoy consultado por el atributo de estatus*/
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date datoUno, Date datoDos);
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation As c group by c.client order by COUNT(c.client) DESC") /*puedo escribir consultas con sql*/
    public List<Object[]>countTotalReservationByClient();
}

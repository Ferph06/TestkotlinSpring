package com.example.demo.dao

import org.springframework.transaction.annotation.Transactional

@Transactional
interface DAO<T> {
	
	fun obtenerTodos():List<T>;
	
	fun obtenerById(id:Int):T;
	
	fun borrarById(id:Int):Boolean;
	
	fun actualizar(obj:T):Boolean;
	
}
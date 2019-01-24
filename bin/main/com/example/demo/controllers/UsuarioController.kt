package com.example.demo.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import com.example.demo.repositorys.UsuarioRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.MediaType
import com.example.demo.pojos.UsuarioPojo
import org.springframework.http.ResponseEntity
import java.util.HashMap
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/api/Usuario/",produces=[MediaType.APPLICATION_JSON_UTF8_VALUE])
class UsuarioController(@Autowired var usuariorep:UsuarioRepository){
	
	@GetMapping(path=["obtenerUsuarios"])
	fun obtenerTodos():ResponseEntity<MutableMap<String,Any>>{
		val map:MutableMap<String,Any> = mutableMapOf();
		map.put("data",usuariorep.obtenerTodos()); 
		return ResponseEntity.ok(map);
	}
	@GetMapping(path=["obtenerById/{id}"])
	fun obenerById(@PathVariable(value="id")  param:Int) : ResponseEntity<MutableMap<String,Any>>{
		val map:MutableMap<String,Any> = mutableMapOf();
		map.put("data",usuariorep.obtenerById(param));
		
		
		return ResponseEntity.ok(map);
	}
}
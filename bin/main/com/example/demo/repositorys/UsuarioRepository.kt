package com.example.demo.repositorys

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import com.example.demo.pojos.UsuarioPojo
import com.example.demo.dao.DAO
import java.util.ArrayList
import org.springframework.beans.factory.annotation.Autowired
import javax.sql.DataSource
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.core.JdbcTemplate
import java.util.logging.Logger


@Repository
open class UsuarioRepository(@Autowired var datasource:DataSource):DAO<UsuarioPojo>{
	val db:JdbcTemplate=JdbcTemplate(datasource);

	
	
	override fun obtenerTodos():List<UsuarioPojo>{
		val ls:MutableList<UsuarioPojo> = mutableListOf();
		db.query("SELECT * FROM Usuario",{res,_->
			val us:UsuarioPojo=UsuarioPojo(res.getInt("idUsuario"),res.getString("nombre"));
			ls.add(us);
		});
		return ls;
	}
	
	override fun obtenerById(id:Int):UsuarioPojo{
		val arr:Array<Any> = arrayOf(id);
		
		return db.query("SELECT * FROM Usuario WHERE idUsuario=?",arr,{res,_->
			 UsuarioPojo(res.getInt("idUsuario"),res.getString("nombre"));
		}).get(0);
	}
	
	override fun borrarById(id:Int):Boolean{
		return false;
	}
	
	override fun actualizar(obj:UsuarioPojo):Boolean{
		return false;
	} 
}
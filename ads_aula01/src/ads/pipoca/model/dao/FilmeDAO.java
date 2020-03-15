package ads.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ads.pipoca.model.entity.Filme;

public class FilmeDAO {
	
	public Filme atualizarFilme(Filme filme) throws Exception { 
		
		if(filme.getId() < 0 ) {
			throw new Exception("Deve ser informado um id de Filme valido");
		}
		
		
		String sql = "UPDATE pipocadb.filme" + 
				" SET" + 
				" titulo = ?," + 
				" descricao = ?," + 
				" diretor = ?," + 
				" posterpath = ?," + 
				" popularidade = ?," + 
				" data_lancamento = ?," + 
				" id_genero = ?" + 
				" WHERE id = ?;";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, filme.getTitulo());
			pst.setString(2, filme.getDescricao());
			pst.setString(3, filme.getDiretor());
			pst.setString(4, filme.getPosterPath());
			pst.setDouble(5, filme.getPopularidade());
			pst.setDate(6, new java.sql.Date(filme.getDataLancamento().getTime()));
			pst.setInt(7, filme.getGenero().getId());
			pst.setInt(8, filme.getId());
			
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return filme;
	}

	public boolean excluirFilme(Filme filme) { 	
		return false;		
	}

	public List<Filme> buscarFilme(Filme filme) { 	
		return null;		
	}
	
	public List<Filme> LIstarTodosFilme() { 	
		return null;		
	}


}

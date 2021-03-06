package br.com.darksun.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.darksun.entity.Personagem;

public class PersonagemController
{
	public List< Personagem > listarPJs( )
	{
		List< Personagem > personagens = new ArrayList< Personagem >( );
		File folder = new File( "resources/pj/" );
		File[ ] lista = folder.listFiles( );
		for ( File file : lista )
			personagens.add( carregar( "resources/pj/" + file.getName( ) ) );
		return personagens;
	}

	public List< Personagem > listarPDMs( )
	{
		List< Personagem > personagens = new ArrayList< Personagem >( );
		File folder = new File( "resources/pdm/" );
		File[ ] lista = folder.listFiles( );
		for ( File file : lista )
			personagens.add( carregar( "resources/pdm/" + file.getName( ) ) );
		return personagens;
	}

	public Personagem carregar( String path )
	{

		Properties prop = new Properties( );
		InputStream input = null;

		try
		{

			input = new FileInputStream( path );

			prop.load( input );

			Personagem personagem = new Personagem( );
			personagem.setIdPersonagem( Integer.parseInt( prop.getProperty( "idPersonagem" ) ) );
			personagem.setNome( prop.getProperty( "nome" ) );
			personagem.setClasse( prop.getProperty( "classe" ) );
			personagem.setImagem( prop.getProperty( "imagem" ) );
			personagem.setCa( Integer.parseInt( prop.getProperty( "ca" ) ) );
			personagem.setBonusIniciativa( Integer.parseInt( prop.getProperty( "bonusIniciativa" ) ) );
			personagem.setHpMaximo( Integer.parseInt( prop.getProperty( "hpMaximo" ) ) );
			personagem.setHpAtual( Integer.parseInt( prop.getProperty( "hpAtual" ) ) );

			return personagem;

		} catch ( IOException ex )
		{
			ex.printStackTrace( );
			return null;
		} finally
		{
			if ( input != null )
			{
				try
				{
					input.close( );
				} catch ( IOException e )
				{
					e.printStackTrace( );
				}
			}
		}

	}
	
	public void criarPersonagemAleatorio( Boolean pj ) {
		Properties prop = new Properties();
		OutputStream output = null;
		
		try {

			if( pj ) {
				output = new FileOutputStream("resources/pj/pjExemplo.properties");

				prop.setProperty("idPersonagem", "1");
				prop.setProperty("nome", "PJ de Exemplo");
				prop.setProperty("classe", "Exemplo");
				prop.setProperty("imagem", "pjExemplo.jpg");
			}else {
				output = new FileOutputStream("resources/pdm/pdmExemplo.properties");

				prop.setProperty("idPersonagem", "2");
				prop.setProperty("nome", "PDM de Exemplo");
				prop.setProperty("classe", "Monstro");
				prop.setProperty("imagem", "pdmExemplo.jpg");
			}
			prop.setProperty("ca", "12");
			prop.setProperty("bonusIniciativa", "1");
			prop.setProperty("hpMaximo", "100");
			prop.setProperty("hpAtual", "10");

			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

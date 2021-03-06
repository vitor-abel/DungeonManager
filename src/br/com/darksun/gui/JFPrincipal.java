package br.com.darksun.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.darksun.control.PersonagemController;
import br.com.darksun.entity.Personagem;

public class JFPrincipal extends JFrame
{
	private final String systemVersion = "1.0.0";
	private Integer width = 1500;
	private Integer height = 750;
	private JPPadrao tela;

	public static void main( String[ ] args )
	{
		EventQueue.invokeLater( new Runnable( )
		{
			public void run( )
			{
				JFPrincipal frame = new JFPrincipal( );
			}
		} );
	}

	public JFPrincipal( )
	{
		this.setVisible( true );
		this.setSize( width, height );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setLayout( null );
		this.setTitle( "Dungeon Manager " + systemVersion );
		this.preparaMenu( );

		File dirPJ = new File( "resources/pj/" );
		if ( !dirPJ.exists( ) )
		{
			dirPJ.mkdirs( );
			new PersonagemController( ).criarPersonagemAleatorio( true );
		}

		File dirPDM = new File( "resources/pdm/" );
		if ( !dirPDM.exists( ) )
		{
			dirPDM.mkdirs( );
			new PersonagemController( ).criarPersonagemAleatorio( false );
		}

		setTela( new JPInicial( this ) );

	}

	void setIniciativa( Personagem personagem, Integer value )
	{
		personagem.setIniciativa( value );
	}

	public void preparaMenu( )
	{
		JMenuBar menuBar = new JMenuBar( );
		menuBar.setBackground( new Color( 125, 125, 125 ) );
		setJMenuBar( menuBar );

		JMenu fileMenu = new JMenu( "Arquivo" );
		menuBar.add( fileMenu );

		JMenuItem itemNovoCombate = new JMenuItem( "Novo Combate" );
		JMenuItem itemNovoPersonagem = new JMenuItem( "Novo Personagem" );
		JMenuItem itemSobre = new JMenuItem( "Sobre" );
		JMenuItem itemSair = new JMenuItem( "Sair" );

		itemNovoCombate.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				JFPrincipal.this.remove( getTela( ) );

				setTela( new JPInicial( JFPrincipal.this ) );

				revalidate( );
				repaint( );
			}
		} );

		itemNovoPersonagem.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{

			}
		} );
		
		itemSobre.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				JFPrincipal.this.remove( getTela( ) );

				setTela( new JPSobre( JFPrincipal.this ) );

				revalidate( );
				repaint( );
			}
		} );

		itemSair.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				System.exit( 0 );
			}
		} );

		fileMenu.add( itemNovoCombate );
//		fileMenu.add( itemNovoPersonagem ); //Projeto Character Builder
		fileMenu.add( itemSobre );
		fileMenu.addSeparator( );
		fileMenu.add( itemSair );
	}

	public JPPadrao getTela( )
	{
		return tela;
	}

	public void setTela( JPPadrao tela )
	{
		this.tela = tela;
		this.add( tela );
	}
}
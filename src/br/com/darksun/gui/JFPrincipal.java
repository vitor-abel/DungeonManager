package br.com.darksun.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import br.com.darksun.control.PersonagemController;
import br.com.darksun.entity.Personagem;

public class JFPrincipal extends JFrame
{
	private JPanel tela = new JPanel( );
	private Integer width = 1500;
	private Integer height = 750;

	public static void main( String[ ] args )
	{
		EventQueue.invokeLater( new Runnable( )
		{
			public void run( )
			{
				JFPrincipal frame = new JFPrincipal( );

				frame.montaTelaPrincipal( );
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
		this.setTitle( "Dungeon Manager" );
		this.add( this.tela );
	}

	public void montaTelaPrincipal( )
	{
		limpaTela( );

		PersonagemController pc = new PersonagemController( );
		List< Personagem > PJs = pc.listarPJs( );
		List< Personagem > PDMs = pc.listarPDMs( );

		String[ ] listaPJcombo = new String[ PJs.size( ) ];
		String[ ] listaPDMs = new String[ PDMs.size( ) ];

		for ( int i = 0; i < PJs.size( ); i++ )
			listaPJcombo[i] = PJs.get( i ).getNome( );

		for ( int i = 0; i < PDMs.size( ); i++ )
			listaPDMs[i] = PDMs.get( i ).getNome( );

		JComboBox PJComboBox = new JComboBox( listaPJcombo );
		PJComboBox.setBounds( 50, 50, 100, 30 );

		JButton btnAddPJ = new JButton( "Adincionar" );
		btnAddPJ.setBounds( 50, 130, 100, 30 );

		JButton btnAddAllPJ = new JButton( "Adincionar Todos" );
		btnAddAllPJ.setBounds( 200, 130, 150, 30 );

		DefaultListModel PJsSelecionados = new DefaultListModel( );
		JList listaPJ = new JList( PJsSelecionados );
		listaPJ.setVisible( false );
		listaPJ.setBounds( 50, 210, 100, 0 );

		JButton btnRemovePJ = new JButton( "Remover" );
		btnRemovePJ.setBounds( 200, 210, 100, 30 );
		btnRemovePJ.setVisible( false );

		JButton btnRemoveAllPJ = new JButton( "Remover Todos" );
		btnRemoveAllPJ.setBounds( 200, 290, 150, 30 );
		btnRemoveAllPJ.setVisible( false );

		JComboBox PDMComboBox = new JComboBox( listaPDMs );
		PDMComboBox.setBounds( width - 150, 50, 100, 30 );

		JButton btnAddPDM = new JButton( "Adicionar" );
		btnAddPDM.setBounds( width - 150, 130, 100, 30 );

		JButton btnAddAllPDM = new JButton( "Adincionar Todos" );
		btnAddAllPDM.setBounds( width - 350, 130, 150, 30 );

		DefaultListModel PDMsSelecionados = new DefaultListModel( );
		JList listaPDM = new JList( PDMsSelecionados );
		listaPDM.setVisible( false );
		listaPDM.setBounds( width - 150, 210, 100, 0 );

		JButton btnRemovePDM = new JButton( "Remover" );
		btnRemovePDM.setBounds( width - 300, 210, 100, 30 );
		btnRemovePDM.setVisible( false );

		JButton btnRemoveAllPDM = new JButton( "Remover Todos" );
		btnRemoveAllPDM.setBounds( width - 400, 290, 150, 30 );
		btnRemoveAllPDM.setVisible( false );

		JButton btnIniciarCombate = new JButton( "Iniciar Combate" );
		btnIniciarCombate.setBounds( width / 2 - 200 / 2, height / 2 - 30 / 2, 200, 30 );

		this.tela.add( PJComboBox );
		this.tela.add( btnAddPJ );
		this.tela.add( btnAddAllPJ );
		this.tela.add( listaPJ );
		this.tela.add( btnRemovePJ );
		this.tela.add( btnRemoveAllPJ );
		this.tela.add( PDMComboBox );
		this.tela.add( btnAddPDM );
		this.tela.add( btnAddAllPDM );
		this.tela.add( listaPDM );
		this.tela.add( btnRemovePDM );
		this.tela.add( btnRemoveAllPDM );
		this.tela.add( btnIniciarCombate );

		this.addComponentListener( new ComponentAdapter( )
		{
			@Override
			public void componentResized( ComponentEvent e )
			{
				width = getBounds( ).width;
				height = getBounds( ).height;

				tela.setBounds( 0, 0, width, height );
				btnIniciarCombate.setBounds( width / 2 - 200 / 2, height / 2 - 30 / 2,
						btnIniciarCombate.getBounds( ).width, btnIniciarCombate.getBounds( ).height );
				PDMComboBox.setBounds( width - 150, 50, PDMComboBox.getBounds( ).width,
						PDMComboBox.getBounds( ).height );
				btnAddPDM.setBounds( width - 150, 130, btnAddPDM.getBounds( ).width, btnAddPDM.getBounds( ).height );
				btnAddAllPDM.setBounds( width - 350, 130, btnAddAllPDM.getBounds( ).width,
						btnAddAllPDM.getBounds( ).height );
				listaPDM.setBounds( width - 150, 210, listaPDM.getBounds( ).width, listaPDM.getBounds( ).height );
				btnRemovePDM.setBounds( width - 300, 210, btnRemovePDM.getBounds( ).width,
						btnRemovePDM.getBounds( ).height );
				btnRemoveAllPDM.setBounds( width - 350, 290, btnRemoveAllPDM.getBounds( ).width,
						btnRemoveAllPDM.getBounds( ).height );
			}
		} );

		btnAddPJ.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				listaPJ.setVisible( true );
				btnRemovePJ.setVisible( true );
				btnRemoveAllPJ.setVisible( true );
				if ( PJComboBox.getSelectedItem( ) != null )
				{
					PJsSelecionados.addElement( PJComboBox.getSelectedItem( ) );
					listaPJ.setBounds( 50, 210, 100, listaPJ.getBounds( ).height + 20 );
					listaPJ.setSelectedIndex( PJComboBox.getSelectedIndex( ) );
					PJComboBox.removeItem( PJComboBox.getSelectedItem( ) );
				}
			}
		} );

		btnAddAllPJ.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				listaPJ.setVisible( true );
				btnRemovePJ.setVisible( true );
				btnRemoveAllPJ.setVisible( true );
				listaPJ.setSelectedIndex( 0 );
				int size = PJComboBox.getItemCount( );
				for ( int i = 0; i < size; i++ )
				{
					PJsSelecionados.addElement( PJComboBox.getSelectedItem( ) );
					listaPJ.setBounds( 50, 210, 100, listaPJ.getBounds( ).height + 20 );
					listaPJ.setSelectedIndex( PJComboBox.getSelectedIndex( ) );
					PJComboBox.removeItem( PJComboBox.getSelectedItem( ) );
				}
			}
		} );

		btnAddPDM.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				listaPDM.setVisible( true );
				btnRemovePDM.setVisible( true );
				btnRemoveAllPDM.setVisible( true );
				if ( PDMComboBox.getSelectedItem( ) != null )
				{
					PDMsSelecionados.addElement( PDMComboBox.getSelectedItem( ) );
					listaPDM.setBounds( width - 150, 210, 100, listaPDM.getBounds( ).height + 20 );
					listaPDM.setSelectedIndex( PDMComboBox.getSelectedIndex( ) );
					PDMComboBox.removeItem( PDMComboBox.getSelectedItem( ) );
				}
			}
		} );

		btnAddAllPDM.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				listaPDM.setVisible( true );
				btnRemovePDM.setVisible( true );
				btnRemoveAllPDM.setVisible( true );
				listaPDM.setSelectedIndex( 0 );
				int size = PDMComboBox.getItemCount( );
				for ( int i = 0; i < size; i++ )
				{
					PDMsSelecionados.addElement( PDMComboBox.getSelectedItem( ) );
					listaPDM.setBounds( width - 150, 210, 100, listaPDM.getBounds( ).height + 20 );
					listaPDM.setSelectedIndex( PDMComboBox.getSelectedIndex( ) );
					PDMComboBox.removeItem( PDMComboBox.getSelectedItem( ) );
				}
			}
		} );

		btnRemovePJ.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				if ( !PJsSelecionados.isEmpty( ) )
				{
					int index = listaPJ.getSelectedIndex( );
					PJComboBox.addItem( listaPJ.getSelectedValue( ) );
					PJsSelecionados.removeElementAt( index );
					listaPJ.setBounds( listaPJ.getBounds( ).x, listaPJ.getBounds( ).y, listaPJ.getBounds( ).width,
							listaPJ.getBounds( ).height - 20 );
					if ( PJsSelecionados.isEmpty( ) )
					{
						btnRemovePJ.setVisible( false );
						btnRemoveAllPJ.setVisible( false );
					} else
						listaPJ.setSelectedIndex( index );
					if ( index > listaPJ.getLastVisibleIndex( ) )
						listaPJ.setSelectedIndex( listaPJ.getLastVisibleIndex( ) );
					List< String > listaAux = ordenaJList( PJComboBox );
					PJComboBox.removeAllItems( );
					for ( String item : listaAux )
					{
						PJComboBox.addItem( item );
					}

				}
			}
		} );

		btnRemoveAllPJ.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				int size = PJsSelecionados.size( );
				for ( int i = 0; i < size; i++ )
				{
					listaPJ.setSelectedIndex( 0 );
					PJComboBox.addItem( listaPJ.getSelectedValue( ) );
					PJsSelecionados.removeElementAt( 0 );
				}
				listaPJ.setBounds( listaPJ.getBounds( ).x, listaPJ.getBounds( ).y, listaPJ.getBounds( ).width, 0 );
				btnRemovePJ.setVisible( false );
				btnRemoveAllPJ.setVisible( false );
				List< String > listaAux = ordenaJList( PJComboBox );
				PJComboBox.removeAllItems( );
				for ( String item : listaAux )
				{
					PJComboBox.addItem( item );
				}
			}
		} );

		btnRemovePDM.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				if ( !PDMsSelecionados.isEmpty( ) )
				{
					int index = listaPDM.getSelectedIndex( );
					PDMComboBox.addItem( listaPDM.getSelectedValue( ) );
					PDMsSelecionados.removeElementAt( index );
					listaPDM.setBounds( listaPDM.getBounds( ).x, listaPDM.getBounds( ).y, listaPDM.getBounds( ).width,
							listaPDM.getBounds( ).height - 20 );
					if ( PDMsSelecionados.isEmpty( ) )
					{
						btnRemovePDM.setVisible( false );
						btnRemoveAllPDM.setVisible( false );
					} else
						listaPDM.setSelectedIndex( index );
					if ( index > listaPDM.getLastVisibleIndex( ) )
						listaPDM.setSelectedIndex( listaPDM.getLastVisibleIndex( ) );
					List< String > listaAux = ordenaJList( PDMComboBox );
					PDMComboBox.removeAllItems( );
					for ( String item : listaAux )
					{
						PDMComboBox.addItem( item );
					}

				}
			}
		} );

		btnRemoveAllPDM.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				int size = PDMsSelecionados.size( );
				for ( int i = 0; i < size; i++ )
				{
					listaPDM.setSelectedIndex( 0 );
					PDMComboBox.addItem( listaPDM.getSelectedValue( ) );
					PDMsSelecionados.removeElementAt( 0 );
				}
				listaPDM.setBounds( listaPDM.getBounds( ).x, listaPDM.getBounds( ).y, listaPDM.getBounds( ).width, 0 );
				btnRemovePDM.setVisible( false );
				btnRemoveAllPDM.setVisible( false );
				List< String > listaAux = ordenaJList( PDMComboBox );
				PDMComboBox.removeAllItems( );
				for ( String item : listaAux )
				{
					PDMComboBox.addItem( item );
				}
			}
		} );

		btnIniciarCombate.addActionListener( new ActionListener( )
		{
			public void actionPerformed( ActionEvent e )
			{
				int PJsize = listaPJ.getLastVisibleIndex( ) + 1;
				int PDMsize = listaPDM.getLastVisibleIndex( ) + 1;

				if ( PJsize < 0 )
				{
					System.out.println( "Selecione pelo menos um PJ" );
					return;
				}

				if ( PDMsize < 0 )
				{
					System.out.println( "Selecione pelo menos um PDM" );
					return;
				}

				List< Personagem > PJcombate = new ArrayList< Personagem >( );
				List< Personagem > PDMcombate = new ArrayList< Personagem >( );

				for ( int i = 0; i < PJsize; i++ )
				{
					listaPJ.setSelectedIndex( i );

					for ( Personagem personagem : PJs )
					{
						if ( personagem.getNome( ).equals( listaPJ.getSelectedValue( ) ) )
						{
							PJcombate.add( personagem );
							break;
						}
					}
				}

				for ( int i = 0; i < PDMsize; i++ )
				{
					listaPDM.setSelectedIndex( i );

					for ( Personagem personagem : PDMs )
					{
						if ( personagem.getNome( ).equals( listaPDM.getSelectedValue( ) ) )
						{
							PDMcombate.add( personagem );
							break;
						}
					}
				}

				montaTelaCombate( PJcombate, PDMcombate );

			}
		} );
	}

	public void montaTelaCombate( List<Personagem> PJs, List<Personagem> PDMs )
	{

		limpaTela( );
		System.out.println( "Combate Iniciado" );

		for ( Personagem personagem : PJs )
			System.out.println( personagem.getNome( ) + " - " + personagem.getHpAtual( ) + " pontos de vida" );

		for ( Personagem personagem : PDMs )
			System.out.println( personagem.getNome( ) + " - " + personagem.getHpAtual( ) + " pontos de vida" );

	}

	public List< String > ordenaJList( JComboBox combobox )
	{
		List< String > array = new ArrayList< String >( );
		int size = combobox.getItemCount( );
		for ( int i = 0; i < size; i++ )
			array.add( combobox.getItemAt( i ).toString( ) );
		Collections.sort( array );

		return array;
	}

	public void limpaTela( )
	{
		this.tela.removeAll( );
		this.revalidate( );
		this.repaint( );
		this.tela.setLayout( null );
		this.tela.setBounds( 0, 0, this.getWidth( ), this.getHeight( ) );
		this.tela.setBackground( new Color( 100, 100, 100 ) );
	}

}

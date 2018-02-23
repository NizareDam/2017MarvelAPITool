package fr.tse.fise2.ahlouni.graphicinterface;

import java.awt.BorderLayout;
import javax.swing.SwingWorker;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.tse.fise2.ahlouni.database.Autocomplete;
import fr.tse.fise2.ahlouni.database.ConnectDB;
import fr.tse.fise2.ahlouni.graphicinterface.UppercaseDocumentFilter;
import fr.tse.fise2.ahlouni.marvelapi.parameter.*;
import fr.tse.fise2.ahlouni.marvelapi.CharacterList;
import fr.tse.fise2.ahlouni.marvelapi.CharacterSummary;
import fr.tse.fise2.ahlouni.marvelapi.Comic;
import fr.tse.fise2.ahlouni.marvelapi.ComicList;
import fr.tse.fise2.ahlouni.marvelapi.ComicPrice;
import fr.tse.fise2.ahlouni.marvelapi.ComicSummary;
import fr.tse.fise2.ahlouni.marvelapi.CreatorList;
import fr.tse.fise2.ahlouni.marvelapi.CreatorSummary;
import fr.tse.fise2.ahlouni.marvelapi.MarvelCharacter;
import fr.tse.fise2.ahlouni.marvelapi.Result;
import fr.tse.fise2.ahlouni.marvelapi.Series;
import fr.tse.fise2.ahlouni.marvelapi.SeriesList;
import fr.tse.fise2.ahlouni.marvelapi.SeriesSummary;
import fr.tse.fise2.ahlouni.marvelapi.StoryList;
import fr.tse.fise2.ahlouni.marvelapi.StorySummary;
import fr.tse.fise2.ahlouni.marvelapi.parameter.ComicParametersBuilder;
import fr.tse.fise2.ahlounibis.BuildUrl;
import fr.tse.fise2.ahlounibis.ResultException;
import fr.tse.fise2.ahlounibis.ResultUrl;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import org.wikidata.wdtk.datamodel.interfaces.Sites;
import org.wikidata.wdtk.dumpfiles.DumpProcessingController;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTree;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Interface extends JFrame {
	private JScrollPane scrollPane_2 = new JScrollPane();
	private ComicList listcomicRecommande;
	private List<ComicSummary> listcomicRecommandeSummary;
	private DefaultListModel<String> ModeleComicsRecommandes = new DefaultListModel<>();
	private List<ComicSummary> comicSummary;
	private List<SeriesSummary> seriesSummary;
	private JList<String> ComicRecommandes = new JList<String>();
	private JPanel panelCleMarvel = new JPanel();
	private JTextField clePublique = new JTextField();
	private JTextField clePrive = new JTextField();
	private JLabel label_clepublique = new JLabel("Clé publique Marvel  :");
	private JLabel label_cleprive = new JLabel("Clé privée Marvel   :");
	private JButton btnValidate = new JButton("Validate");
	private String langue;
	private List<String> ListComicsLu = new ArrayList<String>();
	private JList jlist_ComicLu = new JList();
	private final JLabel Comment = new JLabel("Comment this commic :");
	private final JPanel commentpanel = new JPanel();
	private final JLabel Vote = new JLabel("Vote");
	private final JTextArea textComment = new JTextArea();
	private final JLabel background = new JLabel("");
	private final JButton btnSend = new JButton("Send");
	private final JSpinner spinner = new JSpinner();

	private final JPanel contentPane = new JPanel();
	private final JLabel MyAccount = new JLabel("My Account !");

	private final JPanel getcontentPane = new JPanel();
	private JLabel label_ComicRead = new JLabel("New label");
	private DefaultMutableTreeNode node_1; // pour la jtree
	private Biblio BiblioUser;
	private List<StorySummary> storySummary;
	private List<CharacterSummary> characterSummary;
	private CharacterList characterList;
	private User connectedUser;
	private String stringRecherche;
	private String connecteSousLeNom;
	private int ModeRecherche = 0;
	private JButton btnAjouterUnCommentaire = new JButton("Comment this comic ");
	private JFrame newFrame = new JFrame();
	private JTextField commentaireField = new JTextField();
	private JLabel lblNewLabel = new JLabel("Comment about the comic :");
	private JLabel lblVote = new JLabel("Vote :");
	private JSpinner spinnerVote = new JSpinner();
	private JButton btnHerosSearch = new JButton("Heros' search");
	private JButton btnSignIn = new JButton("Sign In");
	private JButton btnLogIn = new JButton("Log In");
	private JLabel loading_label = new JLabel("");
	private static ConnectDB db = new ConnectDB();
	private JPanel panel_3 = new JPanel();
	private ArrayList<Comic> l;
	private String lbl_creators;
	private String lbl_characters;
	private CreatorList creatorList;
	private List<CreatorSummary> creatorSummary;
	private List<ComicPrice> comicPrice;
	private JButton wiki_button = new JButton("");
	private JLabel label_price = new JLabel("New label");
	private JLabel label_creator = new JLabel("New label");
	
	private JButton btnRetourn = new JButton("");
	private JScrollPane scrollPane = new JScrollPane();
	private java.net.URL url; // url de notre image
	private Result<Comic> comics;
	private Result<MarvelCharacter> character;
	private Result<Series> serie;
	private DefaultListModel<String> modelComicsLu = new DefaultListModel<>();
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> listComics = new JList<String>();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private Police p;
	private int indexJlist;
	private ResultUrl rest;
	private Thumbnail thumbnail;

	private JFrame frame;
	private JPanel panel_2 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JButton btnRechercheParComics = new JButton("Comics' search");
	private JPanel panel = new JPanel();
	private JTextField textField_title = new JTextField();
	private JLabel label_image = new JLabel("                                 Image");
	protected static final int BLACK_WIDOW_ID = 1009189;
	protected static URI uri;
	private JLabel title_label = new JLabel("New label");
	private final JEditorPane editorPane1 = new JEditorPane();
	private final JEditorPane editorPane = new JEditorPane();
	private DocumentFilter filter = new UppercaseDocumentFilter();
	private JTextField textField_character = new JTextField();
	private JTextField username;
	private final JLabel lblNewLabel_4 = new JLabel("");
	private final JPanel panel_5 = new JPanel();
	private JTextField tx_firstname;
	private JTextField tx_lastname;
	private JTextField tx_email;
	private JTextField tx_identifiant;
	private JTextField tx_password;
	private final JPanel panel_6 = new JPanel();
	private final JLabel lb_enregistrement = new JLabel("Create YOUR account");
	private final JTextField textField_hero = new JTextField();
	private final JTextField textField_comic = new JTextField();
	private final Action action = new SwingAction();
	private final JButton btnretour5 = new JButton("");
	private final JButton btnretour3 = new JButton("");
	private final JLabel lblTextload = new JLabel("Will you find them ?");
	private final JLabel lblTextload2 = new JLabel("INTRUDERS ?");
	private final JButton btn_login = new JButton("Login");
	private final JButton btnRegister = new JButton("Register\r\n");
	private final Action action_1 = new SwingAction_1();
	private final JButton ComicSearch = new JButton("Comics' search");
	private final JButton CharacterSearch = new JButton("Heros' search");
	private final JLabel Label_connected = new JLabel("Connected user :");
	private final JLabel background2 = new JLabel("0");
	private final JLabel load61 = new JLabel("INTRUDERS ?");
	private final JLabel load62 = new JLabel("Will you find them ?");
	private final JLabel load63 = new JLabel("");
	private final JButton btnLogOut = new JButton("LogOut\r\n");
	private final JLabel background6 = new JLabel("\r\n");
	private final JLabel biblio_comicImage = new JLabel("New label");
	private final JTextPane label_commentaireBiblio = new JTextPane();
	private final JLabel label_titre = new JLabel("New label");
	private final JLabel label_Vote = new JLabel("");
	private final JLabel vote_no = new JLabel("");
	private final JLabel vote_ok = new JLabel("");
	private String maClePrive;
	private String maClePublique;
	private JPasswordField passwordField;
	private final JButton deleteComic = new JButton("Delete the comic");
	private final JMenuItem mntmDeleteDb = new JMenuItem("Delete DB");
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JLabel lblMyLibrary = new JLabel("My library  :");
	private final JLabel lblNewLabel_1 = new JLabel("You may like : ");

	/**
	 * Lancer l'application
	 */
	// Méthode pour ouvrir le navigateur
	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				/* TODO: error handling */ }
		} else {
			/* TODO: error handling */ }
	}

	class OpenUrlAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			open(uri);
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {

					Interface window = new Interface();
					// Positionner la frame au milieu
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					// Capitalize first letter of JTextArea seems working

					System.out.println(dim);
					window.frame.setLocation(dim.width / 2 - window.frame.getSize().width / 2,
							dim.height / 2 - window.frame.getSize().height / 2);
					window.frame.setResizable(false);
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Créer l'application ( initialiser)
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialiser le contenu de la fenêtre
	 */
	private void initialize() {

		Object[] elements = new Object[] { "Cat", "Dog", "Lion", "Mouse" };

		clePublique.setVisible(true);
		clePrive.setVisible(true);
		label_clepublique.setVisible(true);
		label_cleprive.setVisible(true);
		btnValidate.setVisible(true);
		/// Frame pour l'ajout commentaire :
		newFrame = new JFrame();
		lbl_creators = "Creators";
		lbl_characters = "Characters";
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		newFrame.setLocation(dim.width / 2 - newFrame.getSize().width / 2,
				dim.height / 2 - newFrame.getSize().height / 2);

		newFrame.setVisible(false);

		newFrame.setBounds(dim.width / 2 - 300, dim.height / 2 - 150, 606, 230);

		newFrame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		newFrame.getContentPane().add(commentpanel);
		commentpanel.setLayout(null);

		Comment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Comment.setBounds(21, 5, 170, 17);
		commentpanel.add(Comment);

		Vote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Vote.setBounds(493, 5, 46, 14);
		commentpanel.add(Vote);

		textComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textComment.setBackground(new Color(255, 255, 255));
		textComment.setBounds(21, 33, 229, 73);
		commentpanel.add(textComment);

		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinner.setBounds(493, 33, 55, 31);
		commentpanel.add(spinner);

		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSend.setBounds(491, 125, 89, 23);
		commentpanel.add(btnSend);

		background.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/images/fond_frame2.jpg")));
		background.setBounds(0, 0, 600, 200);
		commentpanel.add(background);
		textField_comic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_comic.setBounds(539, 424, 216, 37);
		textField_comic.setColumns(10);
		textField_hero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_hero.setBounds(539, 478, 216, 43);
		textField_hero.setColumns(10);
		maClePrive = "529d4de6ac8f301319e78df178f1cc3b";
		maClePublique = "aaf515b83cd2a85fc5cabbeedcbd23a163bc4c60";

		Label_connected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame = new JFrame();
		// positionner la fenêtre au milieu

		frame.setBounds(100, 100, 1100, 640);

		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 1100, 640);

		frame.getContentPane().add(panel);

		// panel.
		panel.setLayout(new CardLayout(0, 0));
		textField_title.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField_title.setBounds(299, 426, 218, 30);
		((AbstractDocument) textField_title.getDocument()).setDocumentFilter(filter);
		textField_title.setColumns(10);
		// textField_title.addActionListener(btnRechercheParComics.getAction());
		// Ajout du filtre
		((AbstractDocument) textField_character.getDocument()).setDocumentFilter(filter);
		//

		Label_connected.setFont(p.content2);
		panel_1.setBackground(Color.BLACK);
		panel.add(panel_1, "name_332991625597835");
		panel_1.setLayout(null);
		btnRechercheParComics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRechercheParComics.setBounds(573, 426, 216, 30);
		panel_1.add(btnRechercheParComics);
		panel_1.add(textField_title);
		panel.add(panel_1);
		textField_character.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// Détecter le boutton "Entrer" pour les deux JTextArea de recherche :
		textField_character.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					btnHerosSearch.doClick();
				}
			}
		});
		textField_title.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					btnRechercheParComics.doClick();
				}
			}
		});
		btnHerosSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnHerosSearch.setBounds(573, 483, 216, 30);
		panel_1.add(btnHerosSearch);

		textField_character.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		textField_character.setBounds(299, 482, 218, 30);
		panel_1.add(textField_character);
		textField_character.setColumns(10);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_character.setText("");
				textField_title.setText("");
				panel.removeAll();
				panel.add(panel_3);
				panel.repaint();
				panel.revalidate();
			}
		});

		btnLogIn.setBounds(898, 41, 152, 23);
		panel_1.add(btnLogIn);
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_character.setText("");
				textField_title.setText("");
				panel.removeAll();
				panel.add(panel_5);
				panel.repaint();
				panel.revalidate();
			}
		});
		label_commentaireBiblio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		label_commentaireBiblio.setVisible(false);
		biblio_comicImage.setVisible(false);
		label_Vote.setVisible(false);
		label_titre.setVisible(false);
		label_titre.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnSignIn.setBounds(744, 41, 142, 23);
		panel_1.add(btnSignIn);
		loading_label.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/load.gif")));
		loading_label.setVisible(false);
		lblTextload.setForeground(Color.WHITE);
		lblTextload.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTextload.setBackground(Color.BLACK);
		lblTextload.setBounds(413, 507, 386, 43);

		panel_1.add(lblTextload);
		lblTextload.setVisible(false);
		btnAjouterUnCommentaire.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnAjouterUnCommentaire.setVisible(false);
		lblTextload2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTextload2.setBackground(Color.BLACK);
		lblTextload2.setForeground(Color.WHITE);
		lblTextload2.setBounds(448, 51, 196, 23);

		panel_1.add(lblTextload2);
		lblTextload2.setVisible(false);
		loading_label.setBounds(309, 95, 430, 430);
		panel_1.add(loading_label);
		lblNewLabel_4.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/images/fond_acceuil.jpeg")));
		lblNewLabel_4.setBounds(158, 95, 784, 300);
		panel_1.add(lblNewLabel_4);

		db.connectionToDerby();

		AutoSuggestor autoSuggestorComic = new AutoSuggestor(textField_comic, frame, null, Color.WHITE.brighter(),
				Color.BLUE, Color.RED, 0.75f) {
			@Override
			boolean wordTyped(String typedWord) {

				// create list for dictionary this in your case might be done via calling a
				// method which queries db and returns results as arraylist
				ArrayList<String> words;
				words = db.getNameWords(connectedUser.getId());

				setDictionary(words);
				// addToDictionary("bye");//adds a single word

				return super.wordTyped(typedWord);// now call super to check for any matches against newest dictionary
			}
		};

		AutoSuggestor autoSuggestorHero = new AutoSuggestor(textField_hero, frame, null, Color.WHITE.brighter(),
				Color.BLUE, Color.RED, 0.75f) {
			@Override
			boolean wordTyped(String typedWord) {

				// create list for dictionary this in your case might be done via calling a
				// method which queries db and returns results as arraylist
				ArrayList<String> words;
				words = db.getNameWords(connectedUser.getId());

				setDictionary(words);
				// addToDictionary("bye");//adds a single word

				return super.wordTyped(typedWord);// now call super to check for any matches against newest dictionary
			}
		};
		btnHerosSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// We hide those components
				if (ModeRecherche == 1) {
					if (textField_hero.getText().length() < 3) {
						JOptionPane.showMessageDialog(null, "3 caracters minimum please !!", "NOT OK",
								JOptionPane.ERROR_MESSAGE);
						return;// return from the method to allow the user to edit the JTextField
					}

					scrollPane_1.setVisible(false);
					background6.setVisible(false);
					textField_hero.setVisible(false);
					textField_comic.setVisible(false);
					btnLogOut.setVisible(false);
					biblio_comicImage.setVisible(false);
					MyAccount.setVisible(false);
					CharacterSearch.setVisible(false);
					ComicSearch.setVisible(false);
					Label_connected.setVisible(false);
					deleteComic.setVisible(false);

					load61.setVisible(true);
					load62.setVisible(true);
					load63.setVisible(true);

					btnAjouterUnCommentaire.setVisible(true);
					stringRecherche = textField_hero.getText();

				} else {
					if (textField_character.getText().length() < 3) {
						JOptionPane.showMessageDialog(null, "3 caracters minimum please !!", "NOT OK",
								JOptionPane.ERROR_MESSAGE);
						return;// return from the method to allow the user to edit the JTextField
					}
					stringRecherche = textField_character.getText();
				}
				// We hide those components

				btnSignIn.setVisible(false);
				btnLogIn.setVisible(false);
				btnRechercheParComics.setVisible(false);
				btnHerosSearch.setVisible(false);
				textField_character.setVisible(false);
				textField_title.setVisible(false);
				lblNewLabel_4.setVisible(false);
				loading_label.setVisible(true);
				lblTextload.setVisible(true);
				lblTextload2.setVisible(true);

				wiki_button.setVisible(true);

				new SwingWorker<Void, String>() {
					@Override
					protected Void doInBackground() throws Exception {
						// Worken hard or hardly worken...

						try {
							long startTime = System.currentTimeMillis();
							System.out.println("temps début" + startTime);
							rest = new ResultUrl(maClePublique, maClePrive);
							character = rest.getCharacter(
									new CharacterParameterBuilder().nameStartsWith(stringRecherche).create());
							l = new ArrayList<Comic>();
							int j = 0;
							while (j < character.getData().getResults().size()) {
								ComicList c = character.getData().getResults().get(j).getComics();
								List<ComicSummary> k = c.getItems();
								Result<Comic> comicsTemp;

								for (int i = 0; i < k.size(); i++) {
									URL url = new URL(k.get(i).getResourceURI());
									String ID_comic = url.getPath().substring(18);
									comicsTemp = rest.getComics(Integer.parseInt(ID_comic));
									l.add(comicsTemp.getData().getResults().get(0));

								}
								j++;
							}

							model.removeAllElements();// On efface notre modèle si on fait une nouvelle recherche
							for (int i = 0; i < l.size(); i++) {
								model.addElement(l.get(i).getTitle());
							}
							// listComics= new JList(model);
							listComics.setModel(model);

							java.net.URL url = new java.net.URL(
									l.get(0).getThumbnail().getPath() + "." + l.get(0).getThumbnail().getExtension());
							System.out.println("Description :" + l.get(0).getDescription());
							System.out.println("Lien de l'image : " + l.get(0).getThumbnail().getPath() + "."
									+ l.get(0).getThumbnail().getExtension());
							thumbnail = new Thumbnail(url);
							label_image.setIcon(thumbnail.getImgIcn());
							long estimatedTime = System.currentTimeMillis() - startTime;
							System.out.println("temps pour charger les données" + estimatedTime);
							// Partie wikipedia

							DumpProcessingController dumpProcessingController = new DumpProcessingController(
									"wikidatawiki");
							Sites sites = dumpProcessingController.getSitesInformation();

							wiki_button.setFont(p.content2);
							wiki_button.setText("<HTML> <FONT color=\"#000099\"><U>"
									+ character.getData().getResults().get(0).getName() + "</U></FONT> "
									+ "    </HTML>");
							uri = new URI(
									sites.getPageUrl("frwiki", character.getData().getResults().get(0).getName()));
							wiki_button.setHorizontalAlignment(SwingConstants.LEFT);
							wiki_button.setBorderPainted(false);
							wiki_button.setOpaque(false);
							wiki_button.setBackground(Color.WHITE);
							wiki_button.setToolTipText(uri.toString());
							wiki_button.addActionListener(new OpenUrlAction());
							long estimatedTime2 = System.currentTimeMillis() - startTime;
							System.out.println("temps apres la partie wikipedia" + estimatedTime2);

							title_label.setFont(p.title1);
							title_label.setText(l.get(0).getTitle());

							// LinkedData Comic Prices :
							comicPrice = l.get(0).getPrices();
							String valuePrice = "";
							for (int i = 0; i < comicPrice.size(); i++) {
								valuePrice += "<html>Prix du comic :<br>" + comicPrice.get(i).getPrice() + "$</html>";
							}
							label_price.setFont(p.content);
							label_price.setText(valuePrice);
							// LinkedData Creators :
							creatorList = l.get(0).getCreators();
							creatorSummary = creatorList.getItems();
							String valueCreators = "<html>" + lbl_creators + " :<br>";
							if (creatorSummary.size() == 0) {
								valueCreators += "(Données non fournies)";
							} else {
								for (int i = 0; i < creatorSummary.size(); i++) {
									valueCreators += creatorSummary.get(i).getName() + "<br>";

								}
							}

							valueCreators += "$</html>";
							label_creator.setFont(p.content);
							label_creator.setText(valueCreators);

							// Création de l'onglet Description + onglet caractères
							tabbedPane.removeAll();

							if (tabbedPane.getTabCount() == 0) {
								tabbedPane.addTab("Description", new JScrollPane(editorPane));
								tabbedPane.addTab("Caractères", new JScrollPane(editorPane1));
							} else {
								// scrollPane=new JScrollPane(editorPane);
								// tabbedPane.add(new JScrollPane(editorPane), 0);
							}

							// LinkedData Characters :
							characterList = l.get(0).getCharacters();
							characterSummary = characterList.getItems();

							String valueCharacter = " " + lbl_characters + " :\n ";
							if (characterSummary.size() == 0) {
								valueCharacter += "(Données non fournies)";
							} else {
								for (int i = 0; i < characterSummary.size(); i++) {
									valueCharacter += characterSummary.get(i).getName() + "\n";
								}
							}

							// editorPane.setFont(p.content);
							// Test editorPane pour éviter de supprimer la description
							editorPane.setEditable(false);
							editorPane.setFocusable(false);
							editorPane.setText(l.get(0).getDescription().toString());

							// editorPane1.setFont(p.content);
							// Test editorPane pour éviter de supprimer les caractères
							editorPane1.setEditable(false);
							editorPane1.setFocusable(false);
							editorPane1.setText(valueCharacter);

							// LinkedData IssueNumber :

							panel_2.repaint();
							panel_2.revalidate();

							panel.add(panel_2);

						} catch (IOException | /* URISyntaxException | */ IndexOutOfBoundsException
								| ResultException e2) {
							if (ModeRecherche == 0) {
								panel.removeAll();
								panel.add(panel_1);
								panel.repaint();
								panel.validate();

								btnSignIn.setVisible(true);
								btnLogIn.setVisible(true);
								btnRechercheParComics.setVisible(true);
								btnHerosSearch.setVisible(true);
								textField_character.setVisible(true);
								textField_title.setVisible(true);
								lblNewLabel_4.setVisible(true);
								loading_label.setVisible(false);
								lblTextload.setVisible(false);
								lblTextload2.setVisible(false);
							}

							if (ModeRecherche == 1) {
								panel.removeAll();
								panel.add(panel_6);
								panel.repaint();
								panel.validate();

								// tree.setVisible(true);
								background6.setVisible(true);
								textField_hero.setVisible(true);
								textField_comic.setVisible(true);
								ComicSearch.setVisible(true);
								CharacterSearch.setVisible(true);
								btnLogOut.setVisible(true);
								Label_connected.setVisible(true);
								scrollPane_1.setVisible(true);
								deleteComic.setVisible(true);
								MyAccount.setVisible(true);

								load61.setVisible(false);
								load62.setVisible(false);
								load63.setVisible(false);
							}

							JOptionPane.showMessageDialog(null, "Aucun Héro avec un tel nom !", "Erreur",
									JOptionPane.ERROR_MESSAGE);
							return null;
						}

						panel.removeAll();
						panel.add(panel_2);
						panel.repaint();
						panel.validate();
						return null;
					}
				}.execute();

			}
		});

		btnRechercheParComics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// We hide those components
				if (ModeRecherche == 1) {
					if (textField_comic.getText().length() < 3) {
						JOptionPane.showMessageDialog(null, "3 caracters minimum please !!", "NOT OK",
								JOptionPane.ERROR_MESSAGE);
						return;// return from the method to allow the user to edit the JTextField
					}
					scrollPane_1.setVisible(false);
					background6.setVisible(false);
					textField_hero.setVisible(false);
					textField_comic.setVisible(false);
					btnLogOut.setVisible(false);
					biblio_comicImage.setVisible(false);
					MyAccount.setVisible(false);
					CharacterSearch.setVisible(false);
					ComicSearch.setVisible(false);
					Label_connected.setVisible(false);
					deleteComic.setVisible(false);

					load61.setVisible(true);
					load62.setVisible(true);
					load63.setVisible(true);

					btnAjouterUnCommentaire.setVisible(true);
					stringRecherche = textField_comic.getText();

				} else {
					if (textField_title.getText().length() < 3) {
						JOptionPane.showMessageDialog(null, "3 caracters minimum please sv !!", "NOT OK",
								JOptionPane.ERROR_MESSAGE);

						return;// return from the method to allow the user to edit the JTextField
					}
					stringRecherche = textField_title.getText();
				}

				btnRechercheParComics.setVisible(false);
				btnHerosSearch.setVisible(false);
				btnSignIn.setVisible(false);
				btnLogIn.setVisible(false);
				textField_character.setVisible(false);
				textField_title.setVisible(false);

				lblNewLabel_4.setVisible(false);
				loading_label.setVisible(true);
				lblTextload.setVisible(true);
				lblTextload2.setVisible(true);

				listComics.clearSelection();
				wiki_button.setVisible(false);

				// On crée un SwingWorker qui va trailler en silence
				// Anything that might block or take a long time to run should be executed in a
				// background thread.
				// SwingWorker just provides nice methods to allow you to easily re-sync updates
				// to the UI
				new SwingWorker<Void, String>() {

					@Override
					protected Void doInBackground() throws Exception {
						// TODO Auto-generated method stub

						// Worken hard or hardly worken... :P

						try {

							if (ModeRecherche == 1) {
								db.insertIntoDico(stringRecherche, connectedUser.getId());

							}
							rest = new ResultUrl(maClePublique, maClePrive);

							comics = rest
									.getComics(new ComicParametersBuilder().nameStartsWith(stringRecherche).create());

							System.out.println(rest.urlFactory.getComicsURL(
									new ComicParametersBuilder().nameStartsWith(stringRecherche).create()));
							if (comics.getData().getResults().size() != 0) {
							}
							// On déclare ListModel (objet) on le remplit avec la population de String (
							// Titres de comics) et on le met dans le JList

							model.removeAllElements(); // On efface notre modèle si on fait une nouvelle recherche
							for (int i = 0; i < comics.getData().getResults().size(); i++) {
								model.addElement(comics.getData().getResults().get(i).getTitle());
							}
							// listComics= new JList(model);

							listComics.setModel(model);

							java.net.URL url = new java.net.URL(
									comics.getData().getResults().get(0).getThumbnail().getPath() + "."
											+ comics.getData().getResults().get(0).getThumbnail().getExtension());
							System.out.println("Description :" + comics.getData().getResults().get(0).getDescription());
							System.out.println(
									"Lien de l'image : " + comics.getData().getResults().get(0).getThumbnail().getPath()
											+ "." + comics.getData().getResults().get(0).getThumbnail().getExtension());
							thumbnail = new Thumbnail(url);
							label_image.setIcon(thumbnail.getImgIcn());
							title_label.setFont(p.title1);
							title_label.setText(comics.getData().getResults().get(0).getTitle());
							// ********************************
							// LinkedData Prices :
							comicPrice = comics.getData().getResults().get(0).getPrices();
							String value = "";
							for (int i = 0; i < comicPrice.size(); i++) {
								value += "<html>Prix du Comic :<br>" + comicPrice.get(i).getPrice() + "$</html>";
							}
							label_price.setFont(p.content);
							label_price.setText(value);
							// ****************************
							// LinkedData Creators :
							creatorList = comics.getData().getResults().get(0).getCreators();
							creatorSummary = creatorList.getItems();
							String valueCreators = "<html>" + lbl_creators + " :<br>";
							if (creatorSummary.size() == 0) {
								valueCreators += "(Données non fournies)";
							} else {
								for (int i = 0; i < creatorSummary.size(); i++) {
									valueCreators += creatorSummary.get(i).getName() + "<br>";

								}
							}

							valueCreators += "</html>";
							label_creator.setFont(p.content);
							label_creator.setText(valueCreators);

							// Format
							System.out.println(comics.getData().getResults().get(0).getFormat());
							// LinkedData Stories

							StoryList k = comics.getData().getResults().get(0).getStories();
							storySummary = k.getItems();
							System.out.println(storySummary.size());
							System.out.println(storySummary.get(0).getName() + " et "
									+ storySummary.get(0).getResourceURI() + " et" + storySummary.get(0).getType());

							// LinkedData Series
							SeriesSummary bobo = comics.getData().getResults().get(0).getSeries();

							System.out.println(bobo.getName());

							// LinkedData Array[ComicSummary]

							comicSummary = comics.getData().getResults().get(0).getCollections();
							System.out.println(comicSummary.size());

							// LinkedData Character :
							characterList = comics.getData().getResults().get(0).getCharacters();

							characterSummary = characterList.getItems();
							System.out.println("taille liste characters" + characterSummary.size());

							String valueCharacter = " Characters :\n";
							if (characterSummary.size() == 0) {
								valueCharacter += "(Données non fournies)";
							} else {
								for (int i = 0; i < characterSummary.size(); i++) {
									valueCharacter += characterSummary.get(i).getName() + "\n";

								}
							}

							// editorPane.setFont(p.content);
							// Test editorPane pour éviter de supprimer la description

							editorPane.setEditable(false);
							editorPane.setFocusable(false);

							editorPane.setText(comics.getData().getResults().get(0).getDescription());

							// editorPane1.setFont(p.content);
							// Test editorPane pour éviter de supprimer les caractères
							editorPane1.setEditable(false);
							editorPane1.setFocusable(false);
							editorPane1.setText(valueCharacter);

							// Création de l'onglet Description + onglet caractères
							tabbedPane.removeAll();

							if (tabbedPane.getTabCount() == 0) {
								tabbedPane.addTab("Description", new JScrollPane(editorPane));
								tabbedPane.addTab("Caractères", new JScrollPane(editorPane1));
							} else {
								// scrollPane=new JScrollPane(editorPane);
								// tabbedPane.add(new JScrollPane(editorPane), 0);
							}

						} catch (IndexOutOfBoundsException | IOException | ResultException e2) {
							if (ModeRecherche == 0) {
								panel.removeAll();
								panel.add(panel_1);
								panel.repaint();
								panel.validate();

								btnSignIn.setVisible(true);
								btnLogIn.setVisible(true);
								btnRechercheParComics.setVisible(true);
								btnHerosSearch.setVisible(true);
								textField_character.setVisible(true);
								textField_title.setVisible(true);
								lblNewLabel_4.setVisible(true);
								loading_label.setVisible(false);
								lblTextload.setVisible(false);
								lblTextload2.setVisible(false);
							}

							if (ModeRecherche == 1) {
								panel.removeAll();
								panel.add(panel_6);
								panel.repaint();
								panel.validate();

								// tree.setVisible(true);
								background6.setVisible(true);
								textField_hero.setVisible(true);
								textField_comic.setVisible(true);
								ComicSearch.setVisible(true);
								CharacterSearch.setVisible(true);
								btnLogOut.setVisible(true);
								Label_connected.setVisible(true);
								scrollPane_1.setVisible(true);
								deleteComic.setVisible(true);
								MyAccount.setVisible(true);

								load61.setVisible(false);
								load62.setVisible(false);
								load63.setVisible(false);
							}

							JOptionPane.showMessageDialog(null, "Acun Comic avec un tel nom!", "Erreur",
									JOptionPane.ERROR_MESSAGE);
							return null;
						}

						panel.removeAll();

						panel.add(panel_2);
						panel.repaint();
						panel.revalidate();

						return null;

					}

				}.execute();

			}

		});
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2, "name_333010933330172");
		panel_2.setLayout(null);
		label_image.setForeground(Color.RED);
		label_image.setBounds(62, 99, 228, 314);
		panel_2.add(label_image);
		title_label.setForeground(Color.WHITE);
		title_label.setBounds(62, 52, 497, 72);
		panel_2.add(title_label);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(73, 424, 779, 158);

		panel_2.add(tabbedPane);
		btnRetourn.setIcon(new ImageIcon(this.getClass()
				.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/Industry-Return-icon.png")));
		btnRetourn.setBounds(12, 13, 49, 33);
		panel_2.add(btnRetourn);
		wiki_button.setForeground(Color.WHITE);
		wiki_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		scrollPane.setBounds(762, 39, 303, 349);
		panel_2.add(scrollPane);
		scrollPane.setViewportView(listComics);

		listComics.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					label_ComicRead.setText("Not read");
					JList source = (JList) e.getSource();
					if (source.getSelectedValue() == null)
						return;
					String selected = source.getSelectedValue().toString();
					indexJlist = source.getSelectedIndex();

					try {
						if (comics != null) {

							url = new java.net.URL(comics.getData().getResults().get(indexJlist).getThumbnail()
									.getPath() + "."
									+ comics.getData().getResults().get(indexJlist).getThumbnail().getExtension());
							System.out.println(
									"Description :" + comics.getData().getResults().get(indexJlist).getDescription());
							System.out.println("Lien de l'image : "
									+ comics.getData().getResults().get(indexJlist).getThumbnail().getPath() + "."
									+ comics.getData().getResults().get(indexJlist).getThumbnail().getExtension());
							thumbnail = new Thumbnail(url);
							label_image.setIcon(thumbnail.getImgIcn());
							title_label.setFont(p.title1);
							title_label.setText(comics.getData().getResults().get(indexJlist).getTitle());

							// LinkedData Comic Prices :
							comicPrice = comics.getData().getResults().get(indexJlist).getPrices();
							String valuePrice = "";
							for (int i = 0; i < comicPrice.size(); i++) {
								valuePrice += "<html>Prix du comic :<br>" + comicPrice.get(i).getPrice() + "$</html>";
							}
							label_price.setFont(p.content);
							label_price.setText(valuePrice);
							// LinkedData Creators :
							creatorList = comics.getData().getResults().get(indexJlist).getCreators();
							creatorSummary = creatorList.getItems();
							System.out.println("taille liste createur" + creatorSummary.size());
							String valueCreators = "<html>" + lbl_creators + " :<br>";
							if (creatorSummary.size() == 0) {
								valueCreators += "(Données non fournies)";
							} else {
								for (int i = 0; i < creatorSummary.size(); i++) {
									valueCreators += creatorSummary.get(i).getName() + "<br>";

								}
							}
							valueCreators += "</html>";
							label_creator.setFont(p.content);
							label_creator.setText(valueCreators);

							// Format
							System.out.println(comics.getData().getResults().get(indexJlist).getFormat());
							// LinkedData Stories

							StoryList k = comics.getData().getResults().get(indexJlist).getStories();
							storySummary = k.getItems();
							System.out.println(storySummary.size());
							System.out.println(storySummary.get(0).getName() + " et "
									+ storySummary.get(0).getResourceURI() + " et" + storySummary.get(0).getType());

							// LinkedData Series
							SeriesSummary bobo = comics.getData().getResults().get(indexJlist).getSeries();

							System.out.println(bobo.getResourceURI());

							// LinkedData Array[ComicSummary]

							comicSummary = comics.getData().getResults().get(indexJlist).getCollections();
							System.out.println(comicSummary.size());

							// LinkedData Characters :
							characterList = comics.getData().getResults().get(indexJlist).getCharacters();
							characterSummary = characterList.getItems();

							String valueCharacter = " " + lbl_characters + " : \n";
							if (characterSummary.size() == 0) {
								valueCharacter += "(Données non fournies)";
							} else {
								for (int i = 0; i < characterSummary.size(); i++) {
									valueCharacter += characterSummary.get(i).getName() + "\n";
								}
							}

							editorPane.setFont(p.content);
							editorPane.setText(comics.getData().getResults().get(indexJlist).getDescription());

							editorPane1.setFont(p.content);
							// Test editorPane pour éviter de supprimer les caractères
							editorPane1.setEditable(false);
							editorPane1.setFocusable(false);
							editorPane1.setText(valueCharacter);
							// Création de l'onglet Description
							tabbedPane.removeAll();

							if (tabbedPane.getTabCount() == 0) {
								tabbedPane.addTab("Description", new JScrollPane(editorPane));
								tabbedPane.addTab("Caractères", new JScrollPane(editorPane1));
							} else {
								// scrollPane=new JScrollPane(editorPane);
								tabbedPane.add(new JScrollPane(editorPane), 0);
							}

							if (ModeRecherche == 1) {
								// Check if comic is already read
								BiblioUser = db.GetInformationBiblio(connectedUser.getId_biblio());
								if (db.checkComicRead(comics.getData().getResults().get(indexJlist).getId(),
										BiblioUser)) {
									label_ComicRead.setVisible(true);
									label_ComicRead.setText("Comic déjà lu");

								}
							}

						}

						else {
							// Pour chaque Comic selectionné dans la liste on va chercher dans la base de
							// donnée si il est lu ou pas
							// Si il est lu => afficher Already read // Afficher commentaire dans l'onglet
							// et vote dans un label

							url = new java.net.URL(l.get(indexJlist).getThumbnail().getPath() + "."
									+ l.get(indexJlist).getThumbnail().getExtension());
							System.out.println("Description :" + l.get(indexJlist).getDescription());
							System.out.println("Lien de l'image : " + l.get(indexJlist).getThumbnail().getPath() + "."
									+ l.get(indexJlist).getThumbnail().getExtension());

							thumbnail = new Thumbnail(url);
							label_image.setIcon(thumbnail.getImgIcn());
							title_label.setFont(p.title1);
							title_label.setText(l.get(indexJlist).getTitle());

							// LinkedData Comic Prices :
							comicPrice = l.get(indexJlist).getPrices();
							String valuePrice = "";
							for (int i = 0; i < comicPrice.size(); i++) {
								valuePrice += "<html>Prix du comic :<br>" + comicPrice.get(i).getPrice() + "$</html>";
							}
							label_price.setFont(p.content);
							label_price.setText(valuePrice);
							// LinkedData Creators :

							creatorList = l.get(indexJlist).getCreators();
							creatorSummary = creatorList.getItems();

							String valueCreators = "<html>" + lbl_creators + " :<br>";
							if (creatorSummary.size() == 0) {
								valueCreators += "(Données non fournies)";
							} else {
								for (int i = 0; i < creatorSummary.size(); i++) {
									valueCreators += creatorSummary.get(i).getName() + "<br>";

								}
							}
							valueCreators += "</html>";
							label_creator.setFont(p.content);
							label_creator.setText(valueCreators);
							// LinkedData Characters :
							characterList = l.get(indexJlist).getCharacters();
							characterSummary = characterList.getItems();

							String valueCharacter = " " + lbl_characters + " :\n ";
							if (characterSummary.size() == 0) {
								valueCharacter += "(Données non fournies)";
							} else {
								for (int i = 0; i < characterSummary.size(); i++) {
									valueCharacter += characterSummary.get(i).getName() + "\n";
								}
							}

							editorPane.setFont(p.content);
							editorPane.setText(l.get(indexJlist).getDescription());

							editorPane1.setFont(p.content);
							// Test editorPane pour éviter de supprimer les caractères
							editorPane1.setEditable(false);
							editorPane1.setFocusable(false);
							editorPane1.setText(valueCharacter);
							// Création de l'onglet Description
							tabbedPane.removeAll();

							if (tabbedPane.getTabCount() == 0) {
								tabbedPane.addTab("Description", new JScrollPane(editorPane));
								tabbedPane.addTab("Caractères", new JScrollPane(editorPane1));
							} else {
								// scrollPane=new JScrollPane(editorPane);
								tabbedPane.add(new JScrollPane(editorPane), 0);
							}

							// Check if comic is already read
							if (ModeRecherche == 1) {
								// Check if comic is already read
								BiblioUser = db.GetInformationBiblio(connectedUser.getId_biblio());
								if (db.checkComicRead(l.get(indexJlist).getId(), BiblioUser)) {
									label_ComicRead.setText("Comic déjà lu");

								}
							}
						}

					} catch (IndexOutOfBoundsException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						panel.removeAll();
						panel.add(panel_1);
						e1.printStackTrace();
						String supportTeam = "prenom.nom@telecom-st-etienne.fr";
						JOptionPane.showMessageDialog(null,
								"Une erreur s'est produite:\n" + e1.getMessage() + '\n'
										+ Thread.currentThread().getStackTrace() + "\n Veuillez contacter le support  ."
										+ supportTeam + "\n Merci :) .",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					// listComics.clearSelection();

				}
			}
		});
		wiki_button.setIcon(new ImageIcon(
				this.getClass().getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/wikipedia-icon.png")));

		wiki_button.setBounds(579, 333, 152, 43);
		panel_2.add(wiki_button);
		label_ComicRead.setVisible(false);
		label_ComicRead.setForeground(Color.WHITE);

		label_ComicRead.setBounds(94, 2, 469, 37);
		panel_2.add(label_ComicRead);
		label_creator.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_creator.setForeground(Color.WHITE);

		label_creator.setBounds(313, 99, 256, 277);
		panel_2.add(label_creator);
		label_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_price.setForeground(Color.WHITE);

		label_price.setBounds(313, 387, 204, 46);
		panel_2.add(label_price);

		btnAjouterUnCommentaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				newFrame.setVisible(true);

			}
		});

		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {

				comics.getData().getResults().get(indexJlist).setCommentaire(textComment.getText());
				comics.getData().getResults().get(indexJlist).setNote((int) spinner.getValue());

				db.addComicsRead(comics.getData().getResults().get(indexJlist).getId(),
						comics.getData().getResults().get(indexJlist).getTitle(), 1,
						comics.getData().getResults().get(indexJlist).getNote(),
						comics.getData().getResults().get(indexJlist).getCommentaire(), connectedUser.getId_biblio());

				JOptionPane.showMessageDialog(null, "Comic ajouter à la librairie !", "Confirmation",
						JOptionPane.PLAIN_MESSAGE);
				spinner.setValue(0);
				textComment.setText("");
				newFrame.dispose();
				return;
			}
		});
		btnAjouterUnCommentaire.setBounds(864, 475, 201, 43);
		panel_2.add(btnAjouterUnCommentaire);
		background2.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/images/fondpanel6.jpg")));
		background2.setBounds(-465, 0, 1555, 752);

		panel_2.add(background2);

		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// We hide those components :
				loading_label.setVisible(false);
				lblTextload.setVisible(false);
				lblTextload2.setVisible(false);

				// We show those components
				lblNewLabel_4.setVisible(true);
				btnRechercheParComics.setVisible(true);
				btnHerosSearch.setVisible(true);
				textField_character.setVisible(true);
				textField_title.setVisible(true);
				btnSignIn.setVisible(true);
				btnLogIn.setVisible(true);
				if (ModeRecherche == 0) {
					panel.remove(panel_2);
					textField_title.setText("");
					textField_character.setText("");

					listComics.clearSelection();
					listComics.setValueIsAdjusting(false);
					panel.add(panel_1);
					panel.repaint();
					panel.revalidate();
					btnSignIn.setVisible(true);
					btnLogIn.setVisible(true);
					btnRechercheParComics.setVisible(true);
					btnHerosSearch.setVisible(true);
					textField_character.setVisible(true);
					textField_title.setVisible(true);
					lblNewLabel_4.setVisible(true);
					loading_label.setVisible(false);
					lblTextload.setVisible(false);
					lblTextload2.setVisible(false);

				} else {
					panel.remove(panel_2);
					textField_hero.setText("");
					textField_comic.setText("");

					// tree.setVisible(true);
					background6.setVisible(true);
					textField_hero.setVisible(true);
					textField_comic.setVisible(true);
					ComicSearch.setVisible(true);
					CharacterSearch.setVisible(true);
					btnLogOut.setVisible(true);
					Label_connected.setVisible(true);
					scrollPane_1.setVisible(true);
					deleteComic.setVisible(true);
					MyAccount.setVisible(true);

					load61.setVisible(false);
					load62.setVisible(false);
					load63.setVisible(false);

					listComics.clearSelection();
					listComics.setValueIsAdjusting(false);
					panel.add(panel_6);
					panel.repaint();
					panel.revalidate();

					// Affichage des comics lu dans la JLIST_COMICLU
					connectedUser = db.getInformationUsers(username.getText(), passwordField.getText());
					Label_connected.setText(
							"Bienvenue  : " + connectedUser.getFirstName() + " " + connectedUser.getLastName());
					BiblioUser = db.GetInformationBiblio(connectedUser.getId_biblio());
					modelComicsLu.removeAllElements(); // On efface notre modèle si on fait une nouvelle recherche
					ListComicsLu = db.getListComic(BiblioUser.getId_biblio());
					for (int i = 0; i < ListComicsLu.size(); i++) {
						modelComicsLu.addElement(ListComicsLu.get(i));
						System.out.println(ListComicsLu.get(i));
					}
					jlist_ComicLu.setModel(modelComicsLu);

				}

			}
		});
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3, "name_662608242930364");
		panel_3.setLayout(null);
		editorPane.setBounds(236, 292, 387, 139);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setForeground(Color.BLACK);
		username.setBounds(788, 261, 250, 30);
		panel_3.add(username);
		username.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(788, 352, 250, 33);
		panel_3.add(passwordField);

		JLabel tryToConnect = new JLabel("Try to Connect !");
		tryToConnect.setBackground(Color.BLACK);
		tryToConnect.setForeground(Color.WHITE);
		tryToConnect.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tryToConnect.setBounds(105, 11, 555, 42);
		panel_3.add(tryToConnect);

		JLabel label_username = new JLabel("Username");
		label_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_username.setForeground(Color.WHITE);
		label_username.setBounds(810, 220, 137, 30);
		panel_3.add(label_username);

		JLabel label_password = new JLabel("Password");
		label_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_password.setForeground(Color.WHITE);
		label_password.setBounds(810, 302, 137, 43);
		panel_3.add(label_password);
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 16));

		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					btn_login.doClick();
				}
			}
		});

		btn_login.setBounds(788, 415, 250, 30);
		panel_3.add(btn_login);
		btnretour3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				username.setText("");
				passwordField.setText("");
				panel.add(panel_1);
				panel.repaint();
				panel.revalidate();
				btnSignIn.setVisible(true);
				btnLogIn.setVisible(true);
				btnRechercheParComics.setVisible(true);
				btnHerosSearch.setVisible(true);
				textField_character.setVisible(true);
				textField_title.setVisible(true);
				lblNewLabel_4.setVisible(true);
				loading_label.setVisible(false);
				lblTextload.setVisible(false);
				lblTextload2.setVisible(false);
			}
		});
		btnretour3.setIcon(new ImageIcon(Interface.class
				.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/Industry-Return-icon.png")));
		btnretour3.setBounds(33, 20, 49, 33);

		panel_3.add(btnretour3);

		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(Interface.class
				.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/images/attente_enregister.jpg")));
		lblNewLabel_3.setBounds(-495, -13, 1553, 752);
		panel_3.add(lblNewLabel_3);
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				db.connectionToDerby();

				db.readRows();
				if (db.checkLogin(username.getText(), passwordField.getText()) == true) {
					ModeRecherche = 1;
					panel.removeAll();
					panel.add(panel_6);
					panel.repaint();
					panel.revalidate();
					// Affichage des comics lu dans la JLIST_COMICLU
					connectedUser = db.getInformationUsers(username.getText(), passwordField.getText());
					Label_connected.setText(
							"Bienvenue  : " + connectedUser.getFirstName() + " " + connectedUser.getLastName());
					BiblioUser = db.GetInformationBiblio(connectedUser.getId_biblio());
					modelComicsLu.removeAllElements(); // On efface notre modèle si on fait une nouvelle recherche
					ListComicsLu = db.getListComic(BiblioUser.getId_biblio());
					for (int i = 0; i < ListComicsLu.size(); i++) {
						modelComicsLu.addElement(ListComicsLu.get(i));
						System.out.println(ListComicsLu.get(i));
					}
					jlist_ComicLu.setModel(modelComicsLu);

				} else {
					JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe incorrecte");
				}

			}
		});
		panel_5.setBackground(Color.WHITE);

		panel.add(panel_5, "name_1888275022868625");
		panel_5.setLayout(null);

		tx_firstname = new JTextField();
		tx_firstname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tx_firstname.setBounds(599, 96, 182, 33);
		panel_5.add(tx_firstname);
		tx_firstname.setColumns(10);

		tx_lastname = new JTextField();
		tx_lastname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tx_lastname.setBounds(599, 158, 182, 33);
		panel_5.add(tx_lastname);
		tx_lastname.setColumns(10);

		tx_email = new JTextField();
		tx_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tx_email.setBounds(599, 221, 182, 33);
		panel_5.add(tx_email);
		tx_email.setColumns(10);

		tx_identifiant = new JTextField();
		tx_identifiant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tx_identifiant.setBounds(599, 340, 182, 33);
		panel_5.add(tx_identifiant);
		tx_identifiant.setColumns(10);

		tx_password = new JTextField();
		tx_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tx_password.setBounds(599, 400, 182, 33);
		panel_5.add(tx_password);
		tx_password.setColumns(10);

		JLabel label_firstname = new JLabel("First Name");
		label_firstname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_firstname.setForeground(Color.WHITE);
		label_firstname.setBounds(382, 93, 172, 39);
		panel_5.add(label_firstname);

		JLabel label_name = new JLabel("Name\r\n");
		label_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_name.setForeground(Color.WHITE);
		label_name.setBounds(382, 155, 172, 39);
		panel_5.add(label_name);

		JLabel label_mail = new JLabel("Mail");
		label_mail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_mail.setForeground(Color.WHITE);
		label_mail.setBounds(382, 219, 172, 36);
		panel_5.add(label_mail);

		JLabel label_identifiant = new JLabel("Username\r\n");
		label_identifiant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_identifiant.setForeground(Color.WHITE);
		label_identifiant.setBounds(382, 337, 172, 39);
		panel_5.add(label_identifiant);

		JLabel label_passw = new JLabel("Password\r\n");
		label_passw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_passw.setForeground(Color.WHITE);
		label_passw.setBounds(382, 400, 172, 33);
		panel_5.add(label_passw);

		tx_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					btnRegister.doClick();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				db.connectionToDerby();

				db.register(db.getLastIdIdentifiant() + 1, tx_firstname.getText(), tx_lastname.getText(),
						tx_email.getText(), tx_identifiant.getText(), tx_password.getText(), db.getLastIdBib() + 1);

				/*
				 * Problem with premium account db.register(db.getLastId() + 1,
				 * tx_firstname.getText(), tx_lastname.getText(), tx_email.getText(),
				 * comboBox.getSelectedItem().toString(), tx_identifiant.getText(),
				 * tx_password.getText()); db.readRows();
				 */

				tx_password.setText("");
				tx_identifiant.setText("");

				panel.removeAll();

				panel.add(panel_3);
				panel.repaint();
				panel.revalidate();

			}
		});
		btnRegister.setBounds(480, 478, 110, 33);
		panel_5.add(btnRegister);
		lb_enregistrement.setForeground(Color.WHITE);
		lb_enregistrement.setBounds(134, 11, 400, 49);
		lb_enregistrement.setFont(new Font("Calibri", Font.BOLD, 32));
		panel_5.add(lb_enregistrement);
		btnretour5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();

				panel.add(panel_1);
				panel.repaint();
				panel.revalidate();
				btnSignIn.setVisible(true);
				btnLogIn.setVisible(true);
				btnRechercheParComics.setVisible(true);
				btnHerosSearch.setVisible(true);
				textField_character.setVisible(true);
				textField_title.setVisible(true);
				lblNewLabel_4.setVisible(true);
				loading_label.setVisible(false);
				lblTextload.setVisible(false);
				lblTextload2.setVisible(false);

			}
		});
		btnretour5.setIcon(new ImageIcon(Interface.class
				.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/Industry-Return-icon.png")));
		btnretour5.setBounds(33, 20, 49, 33);

		panel_5.add(btnretour5);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/images/enregistrer.jpg")));
		background.setBounds(-743, -16, 1843, 941);
		panel_5.add(background);
		panel_6.setBackground(Color.BLACK);
		panel_6.setForeground(Color.BLACK);

		panel.add(panel_6, "name_1896024109538196");
		panel_6.setLayout(null);
		Label_connected.setBackground(Color.WHITE);
		Label_connected.setForeground(Color.BLACK);
		Label_connected.setBounds(27, 26, 320, 37);

		panel_6.add(Label_connected);

		panel_6.add(textField_hero);
		panel_6.add(textField_comic);

		((AbstractDocument) textField_hero.getDocument()).setDocumentFilter(filter);
		((AbstractDocument) textField_comic.getDocument()).setDocumentFilter(filter);
		textField_hero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					CharacterSearch.doClick();
				}
			}
		});
		textField_comic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					ComicSearch.doClick();
				}
			}
		});

		CharacterSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CharacterSearch.setBounds(795, 478, 216, 43);

		panel_6.add(CharacterSearch);

		// button.setAction(btnRechercheParComics.getAction()[0]);
		ComicSearch.addActionListener(btnRechercheParComics.getActionListeners()[0]);
		CharacterSearch.addActionListener(btnHerosSearch.getActionListeners()[0]);
		ComicSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ComicSearch.setBounds(795, 424, 216, 37);

		panel_6.add(ComicSearch);

		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				username.setText("");
				passwordField.setText("");

				// hide component panel 3
				vote_ok.setVisible(false);
				vote_no.setVisible(false);
				label_commentaireBiblio.setText("");
				biblio_comicImage.setText("");
				label_Vote.setText("");
				label_titre.setText("");
				label_commentaireBiblio.setVisible(false);
				biblio_comicImage.setVisible(false);
				label_Vote.setVisible(false);
				label_titre.setVisible(false);

				textField_hero.setText("");
				textField_comic.setText("");
				ModeRecherche = 0;
				connecteSousLeNom = "";
				btnAjouterUnCommentaire.setVisible(false);

				panel.removeAll();

				panel.add(panel_3);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnLogOut.setBounds(683, 27, 138, 30);
		panel_6.add(btnLogOut);

		load61.setBackground(Color.BLACK);
		load61.setForeground(Color.WHITE);
		load61.setFont(new Font("Tahoma", Font.PLAIN, 28));
		load61.setBounds(458, 39, 196, 23);
		load61.setVisible(false);
		biblio_comicImage.setBounds(562, 84, 228, 314);

		panel_6.add(biblio_comicImage);
		MyAccount.setForeground(Color.BLACK);

		MyAccount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		MyAccount.setBounds(448, 15, 182, 43);
		panel_6.add(MyAccount);
		label_commentaireBiblio.setBounds(294, 218, 229, 90);

		panel_6.add(label_commentaireBiblio);
		label_Vote.setForeground(Color.WHITE);
		label_Vote.setBounds(348, 161, 24, 37);

		panel_6.add(label_Vote);

		scrollPane_1.setBounds(29, 105, 224, 321);
		panel_6.add(scrollPane_1);

		deleteComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				db.deleteComic(comics.getData().getResults().get(0).getId());
				JOptionPane.showMessageDialog(null, "Comic supprimé de la bibliothèque !", "Confirmation",
						JOptionPane.PLAIN_MESSAGE);
				label_commentaireBiblio.setVisible(false);
				biblio_comicImage.setVisible(false);
				vote_ok.setVisible(false);
				vote_no.setVisible(false);
				label_Vote.setVisible(false);
				label_titre.setVisible(false);
				modelComicsLu.removeAllElements(); // On efface notre modèle si on fait une nouvelle recherche
				ListComicsLu = db.getListComic(BiblioUser.getId_biblio());
				for (int i = 0; i < ListComicsLu.size(); i++) {
					modelComicsLu.addElement(ListComicsLu.get(i));
					System.out.println(ListComicsLu.get(i));
				}
				jlist_ComicLu.setModel(modelComicsLu);
				jlist_ComicLu.repaint();
				jlist_ComicLu.validate();
			}
		});

		jlist_ComicLu.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				// biblio_comicImage
				// label_commentaireBiblio

				int indexjlist_ComicLu;
				if (!arg0.getValueIsAdjusting()) {

					JList source = (JList) arg0.getSource();
					if (source.getSelectedValue() == null)
						return;
					String selected = source.getSelectedValue().toString();
					indexjlist_ComicLu = source.getSelectedIndex();

					try {
						rest = new ResultUrl(maClePublique, maClePrive);
						comics = rest.getComics(db.getIdComic(selected));
						label_commentaireBiblio.setVisible(true);
						biblio_comicImage.setVisible(true);
						label_Vote.setVisible(true);
						label_titre.setVisible(true);

						java.net.URL url = new java.net.URL(
								comics.getData().getResults().get(0).getThumbnail().getPath() + "."
										+ comics.getData().getResults().get(0).getThumbnail().getExtension());
						System.out.println("Description :" + comics.getData().getResults().get(0).getDescription());

						thumbnail = new Thumbnail(url);
						biblio_comicImage.setIcon(thumbnail.getImgIcn());
						label_titre.setFont(p.content2);
						label_titre.setText("Format du comic :" + comics.getData().getResults().get(0).getFormat());
						label_commentaireBiblio.setText(db.getCommentaireComic(selected));
						label_Vote.setFont(p.content2);

						URL URIseries = new URL(comics.getData().getResults().get(0).getSeries().getResourceURI());
						String ID_comic = URIseries.getPath().substring(18);

						System.out.println(comics.getData().getResults().get(0).getSeries().getResourceURI());
						serie = rest.getSerie(Integer.parseInt(ID_comic));
						System.out.println(serie.getData().getResults().get(0).getStartYear());
						listcomicRecommande = serie.getData().getResults().get(0).getComics();

						listcomicRecommandeSummary = listcomicRecommande.getItems();

						ModeleComicsRecommandes.removeAllElements();
						for (int i = 0; i < listcomicRecommandeSummary.size(); i++) {

							ModeleComicsRecommandes.addElement(listcomicRecommandeSummary.get(i).getName());
						}
						ComicRecommandes.setModel(ModeleComicsRecommandes);

						if (db.getVote(selected) > 0) {
							vote_ok.setVisible(true);
							vote_no.setVisible(false);
						} else if (db.getVote(selected) == 0) {
							vote_ok.setVisible(false);
							vote_no.setVisible(false);
						} else {
							vote_no.setVisible(true);
							vote_ok.setVisible(false);
						}
						label_Vote.setText(String.valueOf(db.getVote(selected)));
					} catch (IndexOutOfBoundsException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						panel.removeAll();
						panel.add(panel_1);
						e1.printStackTrace();
						String supportTeam = "prenom.nom@telecom-st-etienne.fr";
						JOptionPane.showMessageDialog(null,
								"Une erreur s'est produite:\n" + e1.getMessage() + '\n'
										+ Thread.currentThread().getStackTrace() + "\n Veuillez contacter le support  ."
										+ supportTeam + "\n Merci :) .",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		scrollPane_1.setViewportView(jlist_ComicLu);

		scrollPane_2.setBounds(873, 122, 196, 263);
		panel_6.add(scrollPane_2);

		scrollPane_2.setViewportView(ComicRecommandes);
		label_titre.setForeground(Color.WHITE);
		label_titre.setBounds(265, 107, 258, 43);

		panel_6.add(label_titre);
		vote_no.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/if_Bad mark_32436.png")));
		vote_no.setBounds(320, 161, 38, 43);

		panel_6.add(vote_no);
		vote_ok.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/if_001_18_9605.gif")));
		vote_ok.setBounds(382, 159, 38, 48);
		vote_ok.setVisible(false);
		vote_no.setVisible(false);
		panel_6.add(vote_ok);
		deleteComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lblMyLibrary.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMyLibrary.setForeground(Color.WHITE);
		lblMyLibrary.setBounds(27, 66, 226, 37);

		panel_6.add(lblMyLibrary);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(891, 66, 163, 25);

		panel_6.add(lblNewLabel_1);

		deleteComic.setBounds(23, 454, 230, 30);

		panel_6.add(deleteComic);
		panel_6.add(load61);

		load62.setBackground(Color.BLACK);
		load62.setForeground(Color.WHITE);
		load62.setFont(new Font("Tahoma", Font.PLAIN, 28));
		load62.setBounds(430, 501, 386, 43);
		load62.setVisible(false);
		panel_6.add(load62);

		load63.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/icons/load.gif")));
		load63.setBounds(329, 60, 430, 430);

		load63.setVisible(false);
		panel_6.add(load63);

		background6.setIcon(new ImageIcon(
				Interface.class.getResource("/fr/tse/fise2/ahlouni/graphicinterface/res/images/fondpanel63.jpg")));
		background6.setBounds(-465, 0, 1555, 752);
		panel_6.add(background6);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmEntrezVosKeys = new JMenuItem("Changer la clée Marvel");
		mntmEntrezVosKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFrame = new JFrame();

				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				newFrame.setLocation(dim.width / 2 - newFrame.getSize().width / 2,
						dim.height / 2 - newFrame.getSize().height / 2);

				newFrame.setVisible(true);
				newFrame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

				newFrame.setBounds(dim.width / 2 - 300, dim.height / 2 - 150, 450, 300);

				newFrame.getContentPane().add(panelCleMarvel);

				panelCleMarvel.setLayout(null);

				clePublique.setVisible(true);
				clePublique.setFont(new Font("Tahoma", Font.PLAIN, 14));
				clePublique.setBounds(178, 69, 167, 36);
				clePublique.setColumns(10);
				panelCleMarvel.add(clePublique);

				clePrive.setFont(new Font("Tahoma", Font.PLAIN, 14));
				clePrive.setBounds(178, 118, 167, 36);
				clePrive.setColumns(10);
				clePrive.setVisible(true);
				panelCleMarvel.add(clePrive);

				label_clepublique.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_clepublique.setBounds(12, 73, 131, 28);
				panelCleMarvel.add(label_clepublique);
				label_clepublique.setVisible(true);

				label_cleprive.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_cleprive.setBounds(12, 127, 131, 26);
				label_cleprive.setVisible(true);
				panelCleMarvel.add(label_cleprive);

				btnValidate.setBounds(214, 180, 97, 25);
				btnValidate.setVisible(true);
				panelCleMarvel.add(btnValidate);

				System.out.println(maClePrive);

				btnValidate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (clePrive.getText().length() < 5 || clePublique.getText().length() < 5) {
							JOptionPane.showMessageDialog(null, "Entrez une clef public & privée !", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						System.out.println(maClePrive);
						maClePrive = clePrive.getText();
						maClePublique = clePublique.getText();
						System.out.println(clePrive.getText());

						newFrame.dispose();
					}
				});

			}
		});
		mnFichier.add(mntmEntrezVosKeys);

		JMenu mnNewMenu = new JMenu("Langue");
		mnFichier.add(mnNewMenu);

		JMenuItem mntmFranais = new JMenuItem("Français");
		mntmFranais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Changer les labels :
				langue = "FR";
				lblTextload2.setText("Des Intrus ?");
				btnSignIn.setText("S'enregister");
				btnRechercheParComics.setText("Recherche par Comics");
				btnHerosSearch.setText("Recherche par Personnages");
				lblTextload.setText("Saurez-vous les reconnaîtres ?");
				btnAjouterUnCommentaire.setText("Ajouter un commentaire");
				tryToConnect.setText("Connectez-vous !");
				label_username.setText("Identifiant");
				label_password.setText("Mot de passe");
				btn_login.setText("Se connecter");
				label_firstname.setText("Prénom");
				label_name.setText("Nom");
				label_mail.setText("E-mail");
				label_identifiant.setText("Identifiant");
				label_passw.setText("Mot de passe");
				lb_enregistrement.setText("S'enregistrer");
				btnRegister.setText("S'enregistrer");
				load62.setText("Saurez-vous les reconnaîtres ?");
				btnLogOut.setText("Déconnection");
				ComicSearch.setText("Recherche par Comics");
				CharacterSearch.setText("Recherche par Personnages");
				MyAccount.setText("Mon compte !");
				load61.setText("Des Intrus ?");
				lbl_creators = "Créateurs";
				btnLogIn.setText("Connectez-vous");
				lbl_characters = "Characters";
				deleteComic.setText("Supprimer le comic");
			}
		});
		mnNewMenu.add(mntmFranais);

		JMenuItem mntmAnglais = new JMenuItem("Anglais");
		mntmAnglais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogIn.setText("Login");
				langue = "ENG";
				lblTextload2.setText("Intruders ?");
				btnSignIn.setText("Register ");
				btnRechercheParComics.setText("Comic's search ");
				btnHerosSearch.setText("Heroes's search");
				lblTextload.setText("Will you find them ?");
				btnAjouterUnCommentaire.setText("Add a comment ");
				tryToConnect.setText("Try to connect !");
				label_username.setText("Username");
				label_password.setText("Password");
				btn_login.setText("Login");
				label_firstname.setText("Firstname");
				label_name.setText("Lastname");
				label_mail.setText("E-mail");
				label_identifiant.setText("Username");
				label_passw.setText("Password");
				lb_enregistrement.setText("Register");
				btnRegister.setText("Register");
				load62.setText("Will you find them ?");
				btnLogOut.setText("Log out");
				ComicSearch.setText("Comics's search");
				CharacterSearch.setText("Heroes's search");
				MyAccount.setText("My account !");
				load61.setText("Intruders ?");
				lbl_creators = "Creators";
				lbl_characters = "Personnages";
				deleteComic.setText("Delete the comic");
			}
		});
		mnNewMenu.add(mntmAnglais);

		JMenuItem mntmAPropos = new JMenuItem("A propos");
		mnFichier.add(mntmAPropos);
		mntmDeleteDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,
						"Attention ! Vous êtes sur le point de supprimer la BDD : \n - Oui : pour continuer  \n Non : pour annuler ",
						"Supression base de donnée", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "BDD supprimée !");
					db.dropTable();
				} else {
					JOptionPane.showMessageDialog(null, "BDD non supprimée");

				}
			}
		});

		mnFichier.add(mntmDeleteDb);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}

class AutoSuggestor {

	private final JTextField textField;
	private final Window container;
	private JPanel suggestionsPanel;
	private JWindow autoSuggestionPopUpWindow;
	private String typedWord;
	private final ArrayList<String> dictionary = new ArrayList<>();
	private int currentIndexOfSpace, tW, tH;
	private DocumentListener documentListener = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent de) {
			checkForAndShowSuggestions();
		}

		@Override
		public void removeUpdate(DocumentEvent de) {
			checkForAndShowSuggestions();
		}

		@Override
		public void changedUpdate(DocumentEvent de) {
			checkForAndShowSuggestions();
		}
	};
	private final Color suggestionsTextColor;
	private final Color suggestionFocusedColor;

	public AutoSuggestor(JTextField textField, Window mainWindow, ArrayList<String> words, Color popUpBackground,
			Color textColor, Color suggestionFocusedColor, float opacity) {
		this.textField = textField;
		this.suggestionsTextColor = textColor;
		this.container = mainWindow;
		this.suggestionFocusedColor = suggestionFocusedColor;
		this.textField.getDocument().addDocumentListener(documentListener);

		setDictionary(words);

		typedWord = "";
		currentIndexOfSpace = 0;
		tW = 0;
		tH = 0;

		autoSuggestionPopUpWindow = new JWindow(mainWindow);
		autoSuggestionPopUpWindow.setOpacity(opacity);

		suggestionsPanel = new JPanel();
		suggestionsPanel.setLayout(new GridLayout(0, 1));
		suggestionsPanel.setBackground(popUpBackground);

		addKeyBindingToRequestFocusInPopUpWindow();
	}

	private void addKeyBindingToRequestFocusInPopUpWindow() {
		textField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true),
				"Down released");
		textField.getActionMap().put("Down released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {// focuses the first label on popwindow
				for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
					if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
						((SuggestionLabel) suggestionsPanel.getComponent(i)).setFocused(true);
						autoSuggestionPopUpWindow.toFront();
						autoSuggestionPopUpWindow.requestFocusInWindow();
						suggestionsPanel.requestFocusInWindow();
						suggestionsPanel.getComponent(i).requestFocusInWindow();
						break;
					}
				}
			}
		});
		suggestionsPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
		suggestionsPanel.getActionMap().put("Down released", new AbstractAction() {
			int lastFocusableIndex = 0;

			@Override
			public void actionPerformed(ActionEvent ae) {// allows scrolling of labels in pop window (I know very hacky
															// for now :))

				ArrayList<SuggestionLabel> sls = getAddedSuggestionLabels();
				int max = sls.size();

				if (max > 1) {// more than 1 suggestion
					for (int i = 0; i < max; i++) {
						SuggestionLabel sl = sls.get(i);
						if (sl.isFocused()) {
							if (lastFocusableIndex == max - 1) {
								lastFocusableIndex = 0;
								sl.setFocused(false);
								autoSuggestionPopUpWindow.setVisible(false);
								setFocusToTextField();
								checkForAndShowSuggestions();// fire method as if document listener change occured and
																// fired it

							} else {
								sl.setFocused(false);
								lastFocusableIndex = i;
							}
						} else if (lastFocusableIndex <= i) {
							if (i < max) {
								sl.setFocused(true);
								autoSuggestionPopUpWindow.toFront();
								autoSuggestionPopUpWindow.requestFocusInWindow();
								suggestionsPanel.requestFocusInWindow();
								suggestionsPanel.getComponent(i).requestFocusInWindow();
								lastFocusableIndex = i;
								break;
							}
						}
					}
				} else {// only a single suggestion was given
					autoSuggestionPopUpWindow.setVisible(false);
					setFocusToTextField();
					checkForAndShowSuggestions();// fire method as if document listener change occured and fired it
				}
			}
		});
	}

	private void setFocusToTextField() {
		container.toFront();
		container.requestFocusInWindow();
		textField.requestFocusInWindow();
	}

	public ArrayList<SuggestionLabel> getAddedSuggestionLabels() {
		ArrayList<SuggestionLabel> sls = new ArrayList<>();
		for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
			if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
				SuggestionLabel sl = (SuggestionLabel) suggestionsPanel.getComponent(i);
				sls.add(sl);
			}
		}
		return sls;
	}

	private void checkForAndShowSuggestions() {
		typedWord = getCurrentlyTypedWord();

		suggestionsPanel.removeAll();// remove previos words/jlabels that were added

		// used to calcualte size of JWindow as new Jlabels are added
		tW = 0;
		tH = 0;

		boolean added = wordTyped(typedWord);

		if (!added) {
			if (autoSuggestionPopUpWindow.isVisible()) {
				autoSuggestionPopUpWindow.setVisible(false);
			}
		} else {
			showPopUpWindow();
			setFocusToTextField();
		}
	}

	protected void addWordToSuggestions(String word) {
		SuggestionLabel suggestionLabel = new SuggestionLabel(word, suggestionFocusedColor, suggestionsTextColor, this);

		calculatePopUpWindowSize(suggestionLabel);

		suggestionsPanel.add(suggestionLabel);
	}

	public String getCurrentlyTypedWord() {// get newest word after last white spaceif any or the first word if no white
											// spaces
		String text = textField.getText();
		String wordBeingTyped = "";
		if (text.contains(" ")) {
			int tmp = text.lastIndexOf(" ");
			if (tmp >= currentIndexOfSpace) {
				currentIndexOfSpace = tmp;
				wordBeingTyped = text.substring(text.lastIndexOf(" "));
			}
		} else {
			wordBeingTyped = text;
		}
		return wordBeingTyped.trim();
	}

	private void calculatePopUpWindowSize(JLabel label) {
		// so we can size the JWindow correctly
		if (tW < label.getPreferredSize().width) {
			tW = label.getPreferredSize().width;
		}
		tH += label.getPreferredSize().height;
	}

	private void showPopUpWindow() {
		autoSuggestionPopUpWindow.getContentPane().add(suggestionsPanel);
		autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
		autoSuggestionPopUpWindow.setSize(tW, tH);
		autoSuggestionPopUpWindow.setVisible(true);

		int windowX = 0;
		int windowY = 0;

		windowX = container.getX() + textField.getX() + 5;
		if (suggestionsPanel.getHeight() > autoSuggestionPopUpWindow.getMinimumSize().height) {
			windowY = container.getY() + textField.getY() + textField.getHeight()
					+ autoSuggestionPopUpWindow.getMinimumSize().height;
		} else {
			windowY = container.getY() + textField.getY() + textField.getHeight()
					+ autoSuggestionPopUpWindow.getHeight();
		}

		autoSuggestionPopUpWindow.setLocation(windowX, windowY);
		autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
		autoSuggestionPopUpWindow.revalidate();
		autoSuggestionPopUpWindow.repaint();

	}

	public void setDictionary(ArrayList<String> words) {
		dictionary.clear();
		if (words == null) {
			return;// so we can call constructor with null value for dictionary without exception
					// thrown
		}
		for (String word : words) {
			dictionary.add(word);
		}
	}

	public JWindow getAutoSuggestionPopUpWindow() {
		return autoSuggestionPopUpWindow;
	}

	public Window getContainer() {
		return container;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void addToDictionary(String word) {
		dictionary.add(word);
	}

	boolean wordTyped(String typedWord) {

		if (typedWord.isEmpty()) {
			return false;
		}

		boolean suggestionAdded = false;

		for (String word : dictionary) {// get words in the dictionary which we added
			boolean fullymatches = true;
			for (int i = 0; i < typedWord.length(); i++) {// each string in the word
				if (!typedWord.toLowerCase().startsWith(String.valueOf(word.toLowerCase().charAt(i)), i)) {// check for
																											// match
					fullymatches = false;
					break;
				}
			}
			if (fullymatches) {
				addWordToSuggestions(word);
				suggestionAdded = true;
			}
		}
		return suggestionAdded;
	}
}

class SuggestionLabel extends JLabel {

	private boolean focused = false;
	private final JWindow autoSuggestionsPopUpWindow;
	private final JTextField textField;
	private final AutoSuggestor autoSuggestor;
	private Color suggestionsTextColor, suggestionBorderColor;

	public SuggestionLabel(String string, final Color borderColor, Color suggestionsTextColor,
			AutoSuggestor autoSuggestor) {
		super(string);

		this.suggestionsTextColor = suggestionsTextColor;
		this.autoSuggestor = autoSuggestor;
		this.textField = autoSuggestor.getTextField();
		this.suggestionBorderColor = borderColor;
		this.autoSuggestionsPopUpWindow = autoSuggestor.getAutoSuggestionPopUpWindow();

		initComponent();
	}

	private void initComponent() {
		setFocusable(true);
		setForeground(suggestionsTextColor);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);

				replaceWithSuggestedText();

				autoSuggestionsPopUpWindow.setVisible(false);
			}
		});

		getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "Enter released");
		getActionMap().put("Enter released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				replaceWithSuggestedText();
				autoSuggestionsPopUpWindow.setVisible(false);
			}
		});
	}

	public void setFocused(boolean focused) {
		if (focused) {
			setBorder(new LineBorder(suggestionBorderColor));
		} else {
			setBorder(null);
		}
		repaint();
		this.focused = focused;
	}

	public boolean isFocused() {
		return focused;
	}

	private void replaceWithSuggestedText() {
		String suggestedWord = getText();
		String text = textField.getText();
		String typedWord = autoSuggestor.getCurrentlyTypedWord();
		String t = text.substring(0, text.lastIndexOf(typedWord));
		String tmp = t + text.substring(text.lastIndexOf(typedWord)).replace(typedWord, suggestedWord);
		textField.setText(tmp);
	}
}
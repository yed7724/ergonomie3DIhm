package com.ubo.tp.twitub.core;

import java.io.File;

import com.ubo.tp.twitub.controler.CtrlConnexion;
import com.ubo.tp.twitub.controler.CtrlInscription;
import com.ubo.tp.twitub.datamodel.ConsoleObserveur;
import com.ubo.tp.twitub.datamodel.Database;
import com.ubo.tp.twitub.datamodel.IDatabase;
import com.ubo.tp.twitub.datamodel.User;
import com.ubo.tp.twitub.events.file.IWatchableDirectory;
import com.ubo.tp.twitub.events.file.WatchableDirectory;
import com.ubo.tp.twitub.ihm.*;
import com.ubo.tp.twitub.observeurPattern.ObserveurInscription;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitub implements ObserveurInscription {
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	protected CtrlConnexion ctrlConnexion;


protected VueConnexion vueConnexion;




	protected CtrlInscription ctrlInscription;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitubMainFrame mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = true;

	protected VueSelecteurDeRepertoire mSelecteurDeFichier;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	/**
	 * Constructeur.
	 */
	public Twitub() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		this.ctrlInscription = new CtrlInscription(mDatabase, mEntityManager);
		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du selecteur de répertoire
		this.initSelecteurDeRepertoire();


		// Initialisation du répertoire d'échange
		this.initDirectory();
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		// this.mMainView...
	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		VueTwitubMock mock = new VueTwitubMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	protected void initMainView() {


		this.mMainView = new TwitubMainFrame( );
		this.mMainView.addObservateur(this);





	}

	protected void initSelecteurDeRepertoire() {
		this.mSelecteurDeFichier = new VueSelecteurDeRepertoire(this.mEntityManager);
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		ConsoleObserveur console = new ConsoleObserveur();

		mDatabase = new Database();
		mDatabase.addObserver(console);
		mEntityManager = new EntityManager(mDatabase);
	}

	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}




	public void show() {

		initMainView();


		// ... setVisible?
	}


	@Override
	public void updateConnexion() {
		CtrlConnexion ctrlConnexion = new CtrlConnexion(mDatabase);
		ctrlConnexion.addObservateur(this);
		vueConnexion = new VueConnexion(ctrlConnexion);

	}

	@Override
	public void updateInscription() {
		System.out.println("updateInscription");
		VueInscription vueInscription = new VueInscription(ctrlInscription);

	}

	@Override
	public void connecte(User user) {
		System.out.println("connednjkzndjcte");
		vueConnexion.dispose();
		VueUserPage vueUserPage = new VueUserPage(user);
		mMainView.addandvalide(vueUserPage);


	}
}

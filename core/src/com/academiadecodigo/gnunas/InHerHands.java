package com.academiadecodigo.gnunas;

import com.academiadecodigo.gnunas.screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.academiadecodigo.gnunas.map.Map;
import com.academiadecodigo.gnunas.player.Player;
import com.academiadecodigo.gnunas.player.PlayerController;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InHerHands extends Game {

	private Map map;
	private Player player1;
	private PlayerController playerController;
	private Music backgroundMusic;
    private float volume= 1;

	private Music monsterRoarSound;
	private Sound monsterKnifeSound;


    SpriteBatch batch;
    Texture img;
    private int state = 0;

    private MenuScreen menuScreen;

    @Override
    public void create() {

        setScreen(new MenuScreen(this));

        backgroundMusic= Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
        backgroundMusic.setVolume(1);
        backgroundMusic.setLooping(true);
        backgroundMusic.play();

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
		map.disposeMap(batch);
		player1.disposePlayer();
		playerController.disposePlayer();
		backgroundMusic.dispose();

    }

    public enum GameState {
        MAIN_MENU,
        INSTRUCTIONS,
        PLAYING,
        GAME_OVER
    }
}

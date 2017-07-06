/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfiloUtente;

import Exceptions.AnnuncioException;
import Casa.AnnuncioCasa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marco La Salvia
 */
public class ProfileManager {
    private Utente utente;
    private AnnuncioCasa annuncioCasa;

    public ProfileManager(Utente utente, AnnuncioCasa annuncioCasa) {
        this.utente = utente;
        this.annuncioCasa = annuncioCasa;
    }

    public Utente getUtente() {
        return utente;
    }

    public AnnuncioCasa getAnnuncioCasa() {
        return annuncioCasa;
    }

    public void setAnnuncioCasa(AnnuncioCasa annuncioCasa) {
        this.annuncioCasa = annuncioCasa;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }


    @Override
    public String toString() {
        return "\nPROFILO UTENTE\n" + this.utente.toString()+"\n";
    }
    
    public void creaAnnuncio(String descrizioneAggiuntiva, int idAnnuncio, int costo, String nomeCognomeProprietario, String cellulareProprietario, String emailProprietario) throws AnnuncioException{
        if(this.annuncioCasa==null) {
            this.annuncioCasa = new AnnuncioCasa(utente.getIdUtente(), descrizioneAggiuntiva, 0, costo, 
                    nomeCognomeProprietario, cellulareProprietario, emailProprietario, new Date(System.currentTimeMillis()));
            
        } else
            throw new AnnuncioException("Cancellare annuncio precedente prima di crearne uno nuovo!");
    }  
    
}
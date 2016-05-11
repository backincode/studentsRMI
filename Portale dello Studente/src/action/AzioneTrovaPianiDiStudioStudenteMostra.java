package action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Facade;
import model.FacadeImp;
import model.Studente;

public class AzioneTrovaPianiDiStudioStudenteMostra extends Azione {

	@Override
	public String esegui(HttpServletRequest request) {

			try {
				HttpSession sessione = request.getSession();
				int matricola = Integer.valueOf(((String)request.getParameter("studente")));
				List<Studente> studenti = new LinkedList<Studente>();
				String esito = new String();
				Facade sistema = new FacadeImp();
				
				studenti.add(sistema.trovaStudentePerMatricola(matricola));
				studenti.addAll(sistema.trovaStudentePerNome(((String)request.getParameter("studente"))));
				studenti.addAll(sistema.trovaStudentePerCognome(((String)request.getParameter("studente"))));
				
				
				if(!studenti.isEmpty()) {
					for(Studente s : studenti)
						esito += "<tr><td><input class=\"blueButton\" type=\"submit\" name=\"compila\" value=\""+s.getMatricola()+"\" /></td><td>"
								+s.getNome()+"</td><td>"+s.getCognome()+"</td></tr>";
				}
				else
					esito = "Nessuno studente trovato";
				sessione.setAttribute("tipoEsito", esito);
				return "esitoPianoDiStudioStudentiMostra";
			} catch (NumberFormatException e){
				HttpSession sessione = request.getSession();
				List<Studente> studenti = new LinkedList<Studente>();
				String esito = new String();
				Facade sistema = new FacadeImp();
				studenti.addAll(sistema.trovaStudentePerNome(((String)request.getParameter("studente"))));
				studenti.addAll(sistema.trovaStudentePerCognome(((String)request.getParameter("studente"))));
				
				if(!studenti.isEmpty()) {
					for(Studente s : studenti)
						esito += "<tr><td><input class=\"blueButton\" type=\"submit\" name=\"mostra\" value=\""+s.getMatricola()+"\" /></td><td>"
								+s.getNome()+"</td><td>"+s.getCognome()+"</td></tr>";
				}
				else
					esito = "Nessuno studente trovato";
				sessione.setAttribute("tipoEsito", esito);
				return "esitoPianoDiStudioStudentiMostra";
			}
		}

	}

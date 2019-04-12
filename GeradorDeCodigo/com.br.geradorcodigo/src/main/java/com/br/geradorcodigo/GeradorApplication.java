package com.br.geradorcodigo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeradorApplication {

	public static void main(String[] args) throws IOException {

		Scanner ler = new Scanner(System.in);
		List<String> listaNomeColuna = new ArrayList<String>();
		List<String> listaVariavelColuna = new ArrayList<String>();
		List<String> listaTipoColuna = new ArrayList<String>();

		System.out.printf("Insira o nome da Entidade:\n");
		String entidade = ler.nextLine();
		
		System.out.printf("Insira o nome da Entidade no banco de dados:\n");
		String entidadeBD = ler.nextLine();


		int maisUma = 1;

		while (maisUma == 1) {
			System.out.println("Insira o nome da coluna no Banco de Dados:");
			listaNomeColuna.add(ler.nextLine());

			System.out.println("Insira o nome da vari�vel da coluna:");
			listaVariavelColuna.add(ler.nextLine());

			System.out.println("Insira o nome do tipo da coluna:");
			listaTipoColuna.add(ler.nextLine());

			System.out.println("Deseja inserir mais uma coluna? (S=1/N=0):");
			maisUma = Integer.parseInt(ler.nextLine());
			
			System.out.println("Pr�xima coluna!!");
			System.out.println(" ");

		}
		
		Path file = Paths.get("C:\\Users\\marce\\eclipseWorkspace\\GeradorDeCodigo\\com.br.geradorcodigo\\ArquivosGerados\\arquivo.java");
		Files.write(file, gerarController(entidade, entidadeBD, listaNomeColuna, listaVariavelColuna, listaTipoColuna), Charset.forName("UTF-8"));
	}

	private static List<String> gerarController(String entidade, String entidadeBD, List<String> listaNomeColuna, List<String> listaVariavelColuna, List<String> listaTipoColuna) {

		List<String> lines = new ArrayList<String>();

		lines.add("import java.io.Serializable;");
		lines.add("import java.util.ArrayList;");
		lines.add("import java.util.List;");
		lines.add("import javax.persistence.Entity;");
		lines.add("import javax.persistence.GeneratedValue;");
		lines.add("import javax.persistence.GenerationType;");
		lines.add("import javax.persistence.Id;");
		lines.add("");
		lines.add("");
		lines.add("");
		lines.add("@Entity(name = \"" + entidadeBD + "\")");
		lines.add("public class " + entidade + " implements Serializable {");
		lines.add("");
		lines.add("		private static final long serialVersionUID = 1L;");
		lines.add("");
		lines.add("		@Id");
		lines.add("		@GeneratedValue(strategy=GenerationType.IDENTITY)");
		lines.add("		@Column(name=\""+listaNomeColuna.get(0)+"\") ");
		lines.add("		private " + listaTipoColuna.get(0) + " " + listaVariavelColuna.get(0));
		lines.add("");
		
		for(int i=1; i < listaNomeColuna.size(); i++) {
			lines.add("");
			lines.add("		@Column(name=\""+listaNomeColuna.get(i)+"\") ");
			lines.add("		private " + listaTipoColuna.get(i) + " " + listaVariavelColuna.get(i));
		}
		
		for(int i=1; i < listaNomeColuna.size(); i++) {
			
			String variavelComLetraMaiuscula = listaVariavelColuna.get(i).substring(0,1).toUpperCase().concat(listaVariavelColuna.get(i).substring(1));
			lines.add("");
			lines.add("		public "+listaTipoColuna.get(i)+" get"+variavelComLetraMaiuscula+"() {");
			lines.add("			return "+listaVariavelColuna.get(i)+";");
			lines.add("		}");
			lines.add("");
			lines.add("		public void set"+variavelComLetraMaiuscula+"("+listaTipoColuna.get(i)+" "+listaVariavelColuna.get(i)+") {");
			lines.add("			this."+listaVariavelColuna.get(i)+" = "+listaVariavelColuna.get(i)+";");
			lines.add("		}");
		}
		
		lines.add("");
		lines.add("		@Override");
		lines.add("		public int hashCode() {");
		lines.add("			final int prime = 31;");
		lines.add("			int result = 1;");
		lines.add("			result = prime * result + (("+listaVariavelColuna.get(0)+" == null) ? 0 : "+listaVariavelColuna.get(0)+".hashCode());");
		lines.add("			return result;");
		lines.add("		}");
		lines.add("");
		lines.add("		@Override");
		lines.add("		public boolean equals(Object obj) {");
		lines.add("			if (this == obj)");
		lines.add("				return true;");
		lines.add("			if (obj == null)");
		lines.add("				return false;");
		lines.add("			if (getClass() != obj.getClass())");
		lines.add("				return false;");
		lines.add("			"+entidade+" other = ("+entidade+") obj;");
		lines.add("			if ("+listaVariavelColuna.get(0)+" == null) {");
		lines.add("				if (other."+listaVariavelColuna.get(0)+" != null)");
		lines.add("					return false;");
		lines.add("				} else if (!"+listaVariavelColuna.get(0)+".equals(other."+listaVariavelColuna.get(0)+"))");
		lines.add("					return false;");
		lines.add("				return true;");
		lines.add("		}");
		lines.add("}");
		
		return lines;
	}

	private static void montaEntradaColunas() {

		List<String> nomeColuna = new ArrayList<String>();
		List<String> variavelColuna = new ArrayList<String>();
		List<String> tipoColuna = new ArrayList<String>();
	}
}
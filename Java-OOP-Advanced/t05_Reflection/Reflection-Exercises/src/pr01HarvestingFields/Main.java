package pr01HarvestingFields;

import javafx.scene.effect.Reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String input=bf.readLine();



		while(!input.equalsIgnoreCase("HARVEST")){
			Class rsl= RichSoilLand.class;
			Field[] fields=rsl.getDeclaredFields();

			switch (input){
				case "protected":
					Arrays.stream(fields)
							.filter(f->Modifier.isProtected(f.getModifiers()))
							.forEach(f-> System.out.println("protected "+
									f.getType().getSimpleName()+" "+f.getName()));
					break;
				case "private":
					Arrays.stream(fields)
							.filter(f->Modifier.isPrivate(f.getModifiers()))
							.forEach(f-> System.out.println("private "+
									f.getType().getSimpleName()+" "+f.getName()));
					break;
				case "public":
					Arrays.stream(fields)
							.filter(f->Modifier.isPublic(f.getModifiers()))
							.forEach(f-> System.out.println("public "+
									f.getType().getSimpleName()+" "+f.getName()));
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(f-> System.out.println(Modifier.toString(f.getModifiers())+" "+
									f.getType().getSimpleName()+" "+f.getName()));
					break;
			}
			input=bf.readLine();
		}
	}
}

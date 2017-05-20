import java.util.List;

/**
 * Created by icondor on 20/05/2017.
 */
public class ClasaPrincipala {

    public static void main(String[] args) throws Exception{

        List<AgendaItem> agenda;

        agenda = AgendaDBOperations.demoRead();

        for(int i=0;i<agenda.size();i++) {

            AgendaItem ai = agenda.get(i);
            System.out.println(ai.getName()+":"+ai.getPhone());
        }


        //astea vin de undeva
        String name="pop";
        String phone="(+40) 722453643";

        AgendaItem ai = new AgendaItem();
        ai.setName(name);
        ai.setPhone(phone);

        AgendaDBOperations.demoCreate(ai);


        agenda = AgendaDBOperations.demoRead();

        for(int i=0;i<agenda.size();i++) {

            AgendaItem aii = agenda.get(i);
            System.out.println(aii.getName()+":"+aii.getPhone());
        }

    }
}

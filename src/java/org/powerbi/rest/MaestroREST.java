
package org.powerbi.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.powerbi.core.MaestroController;
import org.powerbi.model.Maestro;

/**
 *
 * @author mazu1
 */

@Path("maestro")
public class MaestroREST {
    
    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@QueryParam("datosMaestro") String datosMaestro){
        String out = null;
        MaestroController cm = null;
        Gson gson = new Gson();
        Maestro m = new Maestro();
        try{
            m = gson.fromJson(datosMaestro, Maestro.class);
            cm = new MaestroController();
            cm.save(m);
            out= gson.toJson(m);
        }catch(Exception ex){
            ex.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, ex.toString());
        }
        return Response.status(Response.Status.OK).entity(out).build();   
    }   
    
    
     @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll (@QueryParam("filtro") @DefaultValue("")String filtro){
        String out = null;
        MaestroController ce = null;
        List<Maestro> maestro = null;
        try{
            ce = new MaestroController();
            maestro = ce.getAll(filtro);
            out = new Gson().toJson(maestro);
        }
        catch(Exception e){
            e.printStackTrace();
            out= "{\"exception\":\"Error interno del servidor.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}   
     
    


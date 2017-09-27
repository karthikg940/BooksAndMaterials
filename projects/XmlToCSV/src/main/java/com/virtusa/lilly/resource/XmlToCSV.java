package com.virtusa.lilly.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("/api")
public interface XmlToCSV {
@POST
@Path("/xml")
@Consumes(MediaType.APPLICATION_XML)
public void converter(String xmldata);
}

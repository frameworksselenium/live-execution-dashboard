package live.execution.dashboard.controllers;

import live.execution.dashboard.beans.Execution;
import live.execution.dashboard.services.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class ExecutionController {

    @Autowired
    private ExecutionService executionService;

    @GetMapping("/getExecution")
    public List<Execution> getAllExecution(){
   		return executionService.getAllExecution();
    }

    @GetMapping(path="/getExecution/{id}")
    public Execution getExecutionByID(@PathVariable(value="id") int id){
    	return executionService.getExecutionByID(id);
    }

    @PostMapping("/addExecution")
    public Execution addNewExecution(@RequestBody Execution execution){
        return executionService.addExecution(execution);
    }

    @GetMapping("/getMachineIP")
    public String getMachineIP() throws UnknownHostException {
        return Inet4Address.getLocalHost().getHostAddress();
    }

}

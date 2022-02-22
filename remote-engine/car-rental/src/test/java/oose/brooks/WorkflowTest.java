//package oose.brooks;
//
//import org.camunda.bpm.engine.RuntimeService;
//import org.camunda.bpm.engine.runtime.ProcessInstance;
//import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
//
//@SpringBootTest(classes = ApplicationTest.class)
//@RunWith(SpringRunner.class)
//@ActiveProfiles({ "test" })
//public class WorkflowTest extends AbstractProcessEngineRuleTest {
//
//    @Autowired
//    public RuntimeService runtimeService;
//
//    @Test
//    public void shouldExecuteHappyPath() {
//        // given
//        String processDefinitionKey = "car-rental-process";
//
//        // when
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
//
//        // then
//        assertThat(processInstance).isStarted()
//                .task()
//                .hasDefinitionKey("say-hello")
//                .hasCandidateUser("brooks")
//                .isNotAssigned();
//    }
//
//}

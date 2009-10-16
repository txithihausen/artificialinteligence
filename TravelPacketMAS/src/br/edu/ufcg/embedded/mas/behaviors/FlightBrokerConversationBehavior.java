package br.edu.ufcg.embedded.mas.behaviors;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

import java.io.IOException;

public class FlightBrokerConversationBehavior extends ConversationBehavior {

	public FlightBrokerConversationBehavior(Agent a, ACLMessage message) {
		super(a, message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2820718946376282882L;

	@Override
	public void action() {
		ACLMessage message = myAgent
				.receive(MessageTemplate
						.and(
								MessageTemplate
										.MatchConversationId(this.message
												.getConversationId()),
								MessageTemplate
										.or(
												MessageTemplate
														.MatchPerformative(ACLMessage.FAILURE),
												MessageTemplate
														.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL))));
		
		if(message != null) {
			ACLMessage msg = this.message.createReply();
			msg.setContent(message.getContent());
			msg.setPerformative(message.getPerformative());
			
			try {
				msg.setContentObject(message.getContentObject());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (UnreadableException e) {
				e.printStackTrace();
			}
			
			myAgent.send(msg);	
			completed = true;
		}
		
	}
}

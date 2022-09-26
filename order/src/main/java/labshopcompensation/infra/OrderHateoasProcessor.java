package labshopcompensation.infra;

import labshopcompensation.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Order>> {

    @Override
    public EntityModel<Order> process(EntityModel<Order> model) {
        model.add(Link.of("/inventories/" + model.getContent().getProductId()).withRel("inventory"));
        model.add(Link.of("/deliveries/search/findByOrderId?orderId=" + model.getContent().getId()).withRel("delivery"));

        return model;
    }
}

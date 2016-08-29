package io.angelhack.socialcall.images.attach.order;

import static io.angelhack.socialcall.images.attach.AttachConstants.ORDER_IMAGE_ATTACH_SERVICE_BEAN_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.socialcall.images.attach.AttachImageService;
import io.angelhack.socialcall.images.exception.AttachImageException;

/**
 * @author Ivan
 * @since 29.08.2016
 */
@Component(value = ORDER_IMAGE_ATTACH_SERVICE_BEAN_NAME)
public class OrderImageAttachService implements AttachImageService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void attachImage(String referenceId, String imagePath) throws AttachImageException {
        Order order = findOrderOrder(referenceId);
        order.getImagePaths().add(imagePath);
    }

    private Order findOrderOrder(String referenceId) throws AttachImageException {
        Order order = orderRepository.findByOrderId(referenceId);
        if (order == null) {
            throw new AttachImageException(String.format("Order with; \"%s\" id not found", referenceId));
        }
        return order;
    }

    @Override
    public void deleteAttachment(String referenceId, String imagePath) throws AttachImageException {
        findOrderOrder(referenceId).getImagePaths().remove(imagePath);
    }
}

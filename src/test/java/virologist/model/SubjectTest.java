package virologist.model;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import virologist.view.Observer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

class SubjectTest {
    private Subject subject;
    List<Observer> observers;
    Observer observer1;
    Observer observer2;
    Observer observer3;

    @BeforeEach
    public void init() {
        observer1 = mock(Observer.class);
        observer2 = mock(Observer.class);
        observer3 = mock(Observer.class);
    }

    @SuppressWarnings("unchecked")
    @Test
    void attachTest_not_contained() {
        // Arrange
        observers = mock(ArrayList.class);
        when(observers.contains(observer1)).thenReturn(false);
        subject = new Subject(observers);

        // Act
        subject.attach(observer1);
        
        // Assert
        verify(observers, times(1)).add(observer1);
    }  
    
    @SuppressWarnings("unchecked")
    @Test
    void attachTest_already_contained() {
        // Arrange
        observers = mock(ArrayList.class);
        when(observers.contains(observer1)).thenReturn(true);
        subject = new Subject(observers);

        // Act
        subject.attach(observer1);
        
        // Assert
        verify(observers, times(0)).add(observer1);
    }

    @SuppressWarnings("unchecked")
    @Test
    void detachTest() {
        // Arrange
        observers = mock(ArrayList.class);
        subject = new Subject(observers);

        // Act
        subject.detach(observer1);
        
        // Assert
        verify(observers, times(1)).remove(observer1);
    }

    @Test
    void notifyAllObserversTest() {
        // Arrange
        observers = new ArrayList<>();
        observers.add(observer1);
        observers.add(observer2);
        subject = new Subject(observers);

        // Act
        subject.notifyAllObservers();
        
        // Assert
        verify(observer1, times(1)).update();
        verify(observer2, times(1)).update();
        verify(observer3, times(0)).update();
    }
}
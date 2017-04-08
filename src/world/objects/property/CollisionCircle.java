package world.objects.property;



import java.awt.*;

public class CollisionCircle {
        private final int radius;
        private Point collisionPosition;
        private Point position;

        /**
         * Default constructor
         *
         * @param position the object's position
         * @param radius   the object's collision radius
         */
        public CollisionCircle(final Point position, final int radius) {
            this(position, position, radius);
        }

        /**
         * Default constructor
         *
         * @param position          the object's position
         * @param collisionPosition the position of the collision zone
         * @param radius            the object's collision radius
         */
        public CollisionCircle(final Point position, final Point collisionPosition,
                               final int radius) {
            this.position = position;
            this.radius = radius;
            this.collisionPosition = collisionPosition;
        }

        public int getRadius() {
            return radius;
        }

        public Point getPosition() {
            return position;
        }

        public Point getCollisionPosition() {
            return collisionPosition;
        }

        public void setLocation(final Point location) {
            this.collisionPosition = new Point(collisionPosition.x + location.x - position.x,
                    collisionPosition.y + location.y - position.y);
            this.position = location;
        }
    }
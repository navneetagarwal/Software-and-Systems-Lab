/*
 * Copyright (c) 2006-2009 Erin Catto http://www.box2d.org
 *
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will the authors be held liable for any damages
 * arising from the use of this software.
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 * 1. The origin of this software must not be misrepresented; you must not
 * claim that you wrote the original software. If you use this software
 * in a product, an acknowledgment in the product documentation would be
 * appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 * misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */

/* 
 * Base code for CS 251 Software Systems Lab 
 * Department of Computer Science and Engineering, IIT Bombay
 * 
 */
#include "cs251_base.hpp"
#include "render.hpp"

#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include "GL/freeglut.h"
#endif

#include <cstring>
using namespace std;

#include "dominos.hpp"
/*! \var b2Body* b1
* \brief It is the pointer to b2Body
* It is the pointer to ground
*/

/*! \var b2EdgeShape shape
* \brief An object of type b2EdgeShape. 
* It creates the edge for the horizontal ground
  Defined from -90 to +90
*/

/*! \var b2BodyDef bd
* \brief An object of type b2BodyDef
* It creates the bodies for the Dominos, Ground, Horizontal shelf
Value different at different positions
*/

/*! \var b2PolygonShape shape1
* \brief An object of type b2PolygonShape. 
* It creates the shape of the bodies
Value different at different positions
*/

/*! \var b2FixtureDef fd
* \brief An object of type b2FixtureDef. 
* It creates the shape of the dominos
Density = 20
Friction = 0.1
*/
/*! \var b2Body* b4
* \brief A pointer to the dominos. 
* It creates the shape of the dominos.
*/

/*! \var b2Body* b2
* \brief A pointer to the pendulum
* It creates the pendulum
*/

/*! \var b2RevoluteJointDef jd
* \brief An object of type b2RevoluteJointDef.
* It creates the joint for horizontal shelf
Value different at different positions
*/

/*! \var b2Vec2 anchor
* \brief An object of type b2Vec2. 
* It creates the anchor for the horizontal shelf
Value different at different positions
*/

/*! \var b2Body* spherebody
* \brief A pointer to the train of spheres. 
* It creates the train of spheres
*/

/*! \var b2Body* ground
* \brief Another pointer to ground. 
* It creates the ground
*/

/*! \var b2CircleShape circle
* \brief An object of type b2CircleShape. 
* It creates the ciruclar shape for the spheres
Value different at different positions
*/

/*! \var b2FixtureDef ballfd
* \brief An object of type b2FixtureDef. 
* It creates the fixture for the train of spheres and the heavy sphere
Value different at different positions
*/

/*! \var b2BodyDef ballbd
* \brief An object of type b2BodyDef. 
* It creates the body for the train of spheres and the heavy sphere
Value different at different positions
*/

/*! \var b2BodyDef *bd1
* \brief A pointer to the pulley 
* It creates the pulley
*/

/*! \var b2FixtureDef *fd1
* \brief A pointer to the open box. 
* It creates a side for the open box
*/

/*! \var b2PolygonShape bs1
* \brief An object of type b2PolygonShape. 
* It creates the shape of the side of the open box
X-Position 2
Y-Position 0.2
*/

/*! \var b2PolygonShape bs2
* \brief An object of type b2PolygonShape. 
* It creates the shape of the side of the open box
X- Position 0.2
Y-Position 2

*/

/*! \var b2PolygonShape bs3
* \brief An object of type b2PolygonShape. 
* It creates the shape of the side of the open box
X- Position 0.2
Y-Position 2
*/

/*! \var b2FixtureDef *fd2
* \brief A pointer to the open box. 
* It creates a side for the open box
*/

/*! \var b2FixtureDef *fd3
* \brief A pointer to the open box. 
* It creates a side for the open box
*/

/*! \var b2Body* box1
* \brief An object of type b2Body. 
* It creates the sides of the open box
*/

/*! \var b2Body* box2
* \brief An object of type b2Body. 
* It creates the shape of the bar
*/

/*! \var b2PulleyJointDef* myjoint
* \brief A pointer to the pulley joint. 
* It creates the pulley
*/

/*! \var float32 ratio
* \brief An object of type float32. 
* It defines the ratio of pulley anchor
Value = 1
*/

/*! \var b2PolygonShape shape2
* \brief An object of type b2PolygonShape. 
* It creates the shape of the light box, horizontal platform
Value different at different positions
*/

/*! \var b2BodyDef bd2
* \brief An object of type b2BodyDef. 
* It creates the shape of the plank
*/

/*! \var b2RevoluteJointDef jointDef
* \brief An object of type b2RevoluteJointDef. 
* It creates the revolve joint for the rotating platform
*/

/*! \var b2Body* sbody
* \brief A pointer to spherical body.
* It creates the heavy sphere on the platform
*/

/*! \var b2PolygonShape poly
* \brief An object of type b2PolygonShape. 
* It creates the shape of the triangular Wedge
Triangle at (-1,0), (0,1.5), (1,0)
*/

/*! \var b2FixtureDef wedgefd
* \brief An object of type b2FixtureDef. 
* It creates the fixture for the triangular wedge
Density = 10
Friction = 0
Restitution = 0
*/

/*! \var b2BodyDef wedgebd
* \brief An object of type b2BodyDef. 
* It creates the shape of the of the triangular wedge
Position (30,0)
*/
/*! \var b2PolygonShape plank
* \brief An object of type b2PolygonShape. 
* It creates the shape of the planks extra objects added
Value different at different positions
*/

b2Body* b1; 
b2EdgeShape shape; 
b2BodyDef bd;
b2PolygonShape shape1;
b2FixtureDef fd;
b2Body* b4;
b2Body* b2;
b2RevoluteJointDef jd;
b2Vec2 anchor;
b2Body* spherebody;
b2Body* ground;
b2CircleShape circle;
b2FixtureDef ballfd;
b2BodyDef ballbd;
b2BodyDef *bd1;
b2FixtureDef *fd1;
b2PolygonShape bs1;
b2PolygonShape bs2;
b2PolygonShape bs3;
b2FixtureDef *fd2;
b2FixtureDef *fd3;
b2Body* box1;
b2Body* box2 ;
b2PulleyJointDef* myjoint;
float32 ratio;
b2PolygonShape shape2;
b2BodyDef bd2;
b2RevoluteJointDef jointDef;
b2Body* sbody;
b2PolygonShape poly;
b2FixtureDef wedgefd;
b2BodyDef wedgebd;
b2PolygonShape plank;
namespace cs251
{
  /**  The is the constructor 
   * This is the documentation block for the constructor.
   */ 
  
  dominos_t::dominos_t()
  {
    ///Ground
    /// Integer 1 
    /*! \var int n
    \brief A type definition for a .
    
    Details.
*/
    b2Body* b1;  
    {
      /** \brief Integer 1 */
      b2EdgeShape shape; 
      shape.Set(b2Vec2(-90.0f, 0.0f), b2Vec2(90.0f, 0.0f));
      b2BodyDef bd; 
      b1 = m_world->CreateBody(&bd); 
      b1->CreateFixture(&shape, 0.0f);
    }
          
    //Top horizontal shelf
    {
      b2PolygonShape shape1;
      shape1.SetAsBox(6.0f, 0.25f);
  
      b2BodyDef bd;
      bd.position.Set(-31.0f, 30.0f);
      b2Body* ground = m_world->CreateBody(&bd);
      ground->CreateFixture(&shape1, 0.0f);
    }

    //Dominos
    {
      b2PolygonShape shape1;
      shape1.SetAsBox(0.1f, 1.0f);
  
      b2FixtureDef fd;
      fd.shape = &shape1;
      fd.density = 20.0f;
      fd.friction = 0.1f;
    
      for (int i = 0; i < 10; ++i)
  {
    b2BodyDef bd;
    bd.type = b2_dynamicBody;
    bd.position.Set(-35.5f + 1.0f * i, 31.25f);
    b2Body* body = m_world->CreateBody(&bd);
    body->CreateFixture(&fd);
  }
    }

    b2Body* b4;
    {
      b2PolygonShape shape1;
      shape1.SetAsBox(0.25f, 0.25f);
    
      b2BodyDef bd;
      bd.type = b2_dynamicBody;
      bd.position.Set(-40.0f, 33.0f);
      b4 = m_world->CreateBody(&bd);
      b4->CreateFixture(&shape1, 2.0f);
    }
  
      


    //The pendulum that knocks the dominos off
    {
      b2Body* b2;
      {
  b2PolygonShape shape1;
  shape1.SetAsBox(0.25f, 1.5f);
    
  b2BodyDef bd;
  bd.position.Set(-36.5f, 28.0f);
  b2 = m_world->CreateBody(&bd);
  b2->CreateFixture(&shape1, 10.0f);
      }
  
      //Another horizontal shelf
      {
  b2PolygonShape shape1;
  shape1.SetAsBox(7.0f, 0.25f, b2Vec2(-20.f,20.f), 0.0f);
  
  b2BodyDef bd;
  bd.position.Set(1.0f, 6.0f);
  b2Body* ground = m_world->CreateBody(&bd);
  ground->CreateFixture(&shape1, 0.0f);
      }

      b2RevoluteJointDef jd;
      b2Vec2 anchor;
      anchor.Set(-37.0f, 40.0f);
      jd.Initialize(b2, b4, anchor);
      m_world->CreateJoint(&jd);
    }
      
    //The train of small spheres
    {
      b2Body* spherebody;
  
      b2CircleShape circle;
      circle.m_radius = 0.5;
  
      b2FixtureDef ballfd;
      ballfd.shape = &circle;
      ballfd.density = 1.0f;
      ballfd.friction = 0.0f;
      ballfd.restitution = 0.0f;
  
      for (int i = 0; i < 10; ++i)
  {
    b2BodyDef ballbd;
    ballbd.type = b2_dynamicBody;
    ballbd.position.Set(-22.2f + i*1.0, 26.6f);
    spherebody = m_world->CreateBody(&ballbd);
    spherebody->CreateFixture(&ballfd);
  }
    }

    //The pulley system
    {
      b2BodyDef *bd1 = new b2BodyDef;
      bd1->type = b2_dynamicBody;
      bd1->position.Set(-10,15);
      bd1->fixedRotation = true;
      
      //The open box
      b2FixtureDef *fd1 = new b2FixtureDef;
      fd1->density = 10.0;
      fd1->friction = 0.5;
      fd1->restitution = 0.f;
      fd1->shape = new b2PolygonShape;
      b2PolygonShape bs1;
      bs1.SetAsBox(2,0.2, b2Vec2(0.f,-1.9f), 0);
      fd1->shape = &bs1;
      b2FixtureDef *fd2 = new b2FixtureDef;
      fd2->density = 10.0;
      fd2->friction = 0.5;
      fd2->restitution = 0.f;
      fd2->shape = new b2PolygonShape;
      b2PolygonShape bs2;
      bs2.SetAsBox(0.2,2, b2Vec2(2.0f,0.f), 0);
      fd2->shape = &bs2;
      b2FixtureDef *fd3 = new b2FixtureDef;
      fd3->density = 10.0;
      fd3->friction = 0.5;
      fd3->restitution = 0.f;
      fd3->shape = new b2PolygonShape;
      b2PolygonShape bs3;
      bs3.SetAsBox(0.2,2, b2Vec2(-2.0f,0.f), 0);
      fd3->shape = &bs3;
       
      b2Body* box1 = m_world->CreateBody(bd1);
      box1->CreateFixture(fd1);
      box1->CreateFixture(fd2);
      box1->CreateFixture(fd3);

      //The bar
      bd1->position.Set(10,15); 
      fd1->density = 34.0;    
      b2Body* box2 = m_world->CreateBody(bd1);
      box2->CreateFixture(fd1);

      // The pulley joint
      b2PulleyJointDef* myjoint = new b2PulleyJointDef();
      b2Vec2 worldAnchorOnBody1(-10, 15); // Anchor point on body 1 in world axis
      b2Vec2 worldAnchorOnBody2(10, 15); // Anchor point on body 2 in world axis
      b2Vec2 worldAnchorGround1(-10, 20); // Anchor point for ground 1 in world axis
      b2Vec2 worldAnchorGround2(10, 20); // Anchor point for ground 2 in world axis
      float32 ratio = 1.0f; // Define ratio
      myjoint->Initialize(box1, box2, worldAnchorGround1, worldAnchorGround2, box1->GetWorldCenter(), box2->GetWorldCenter(), ratio);
      m_world->CreateJoint(myjoint);
    }

    //The revolving horizontal platform
    {
      b2PolygonShape shape1;
      shape1.SetAsBox(2.2f, 0.2f);
  
      b2BodyDef bd;
      bd.position.Set(14.0f, 14.0f);
      bd.type = b2_dynamicBody;
      b2Body* body = m_world->CreateBody(&bd);
      b2FixtureDef *fd1 = new b2FixtureDef;
      fd1->density = 1.f;
      fd1->shape = new b2PolygonShape;
      fd1->shape = &shape1;
      body->CreateFixture(fd1);

      b2PolygonShape shape2;
      shape2.SetAsBox(0.2f, 2.0f);
      b2BodyDef bd2;
      bd2.position.Set(14.0f, 16.0f);
      b2Body* body2 = m_world->CreateBody(&bd2);

      b2RevoluteJointDef jointDef;
      jointDef.bodyA = body;
      jointDef.bodyB = body2;
      jointDef.localAnchorA.Set(0,0);
      jointDef.localAnchorB.Set(0,0);
      jointDef.collideConnected = false;
      m_world->CreateJoint(&jointDef);
    }

    //The heavy sphere on the platform
    {
      b2Body* sbody;
      b2CircleShape circle;
      circle.m_radius = 1.0;
  
      b2FixtureDef ballfd;
      ballfd.shape = &circle;
      ballfd.density = 50.0f;
      ballfd.friction = 0.0f;
      ballfd.restitution = 0.0f;
      b2BodyDef ballbd;
      ballbd.type = b2_dynamicBody;
      ballbd.position.Set(14.0f, 18.0f);
      sbody = m_world->CreateBody(&ballbd);
      sbody->CreateFixture(&ballfd);
    }


    //The see-saw system at the bottom
    {
      //The triangle wedge
      b2Body* sbody;
      b2PolygonShape poly;
      b2Vec2 vertices[3];
      vertices[0].Set(-1,0);
      vertices[1].Set(1,0);
      vertices[2].Set(0,1.5);
      poly.Set(vertices, 3);
      b2FixtureDef wedgefd;
      wedgefd.shape = &poly;
      wedgefd.density = 10.0f;
      wedgefd.friction = 0.0f;
      wedgefd.restitution = 0.0f;
      b2BodyDef wedgebd;
      wedgebd.position.Set(30.0f, 0.0f);
      sbody = m_world->CreateBody(&wedgebd);
      sbody->CreateFixture(&wedgefd);

      //The plank on top of the wedge
      b2PolygonShape shape1;
      shape1.SetAsBox(15.0f, 0.2f);
      b2BodyDef bd2;
      bd2.position.Set(30.0f, 1.5f);
      bd2.type = b2_dynamicBody;
      b2Body* body = m_world->CreateBody(&bd2);
      b2FixtureDef *fd2 = new b2FixtureDef;
      fd2->density = 1.f;
      fd2->shape = new b2PolygonShape;
      fd2->shape = &shape1  ;
      body->CreateFixture(fd2);

      b2RevoluteJointDef jd;
      b2Vec2 anchor;
      anchor.Set(30.0f, 1.5f);
      jd.Initialize(sbody, body, anchor);
      m_world->CreateJoint(&jd);

      //The light box on the right side of the see-saw
      b2PolygonShape shape2;
      shape2.SetAsBox(2.0f, 2.0f);
      b2BodyDef bd3;
      bd3.position.Set(42.1f, 2.0f);
      bd3.type = b2_dynamicBody;
      b2Body* body3 = m_world->CreateBody(&bd3);
      b2FixtureDef *fd3 = new b2FixtureDef;
      fd3->density = 0.01f;
      fd3->shape = new b2PolygonShape;
      fd3->shape = &shape2;
      body3->CreateFixture(fd3);
    }
    {
      b2PolygonShape plank;
      plank.SetAsBox(0.25f, 2.0f);
      b2BodyDef bd;
      bd.position.Set(15.0f, 6.0f);
      bd.angle = 0.25f * b2_pi;
      b2Body* ground = m_world->CreateBody(&bd);
      ground->CreateFixture(&plank, 0.0f);
    }
    {
      b2PolygonShape plank;
      plank.SetAsBox(0.25f, 2.0f);
      b2BodyDef bd;
      bd.position.Set(18.0f, 10.5f);
      bd.angle = -0.25f * b2_pi;
      b2Body* ground = m_world->CreateBody(&bd);
      ground->CreateFixture(&plank, 0.0f);
    }
    {
      b2PolygonShape plank;
      plank.SetAsBox(0.25f, 4.0f);
      b2BodyDef bd;
      bd.position.Set(33.7f, 5.0f);
      bd.angle = 0.5*b2_pi;
      b2Body* ground = m_world->CreateBody(&bd);
      b2FixtureDef *fd2 = new b2FixtureDef;
      fd2->friction = 30.0f;
      fd2->shape = new b2PolygonShape;
      fd2->shape = &plank;
      ground->CreateFixture(fd2);
    }
  }


  sim_t *sim = new sim_t("Dominos", dominos_t::create);
}

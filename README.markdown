Revelation
==========

Revelation is a framework for building tools that manage versioned migrations for arbitrary data stores.  By defining a few integration points, Revelation can be used to produce tools that work closely with data stores to understand what changes have been applied, and what work needs to be done to bring them up to a more recent version.  While there are many mature tools for this in SQL databases, this seems to be missing for many other systems.

For example, many applications utilizing "NoSQL" stores (Redis, MongoDB, etc.) have a need to make occasional changes to data, corresponding with new versions of the code.  In some cases this is best handled lazily, with the code itself performing changes as necessary.  Many times though, this leads to cluttered logic as data conforming to several old schemas must be accounted for.

The general idea is that by defining the following, a system for managing these migrations can be quickly created.

* How do we obtain the ordered list of all defined changes?
* How do we retrieve from the data store all of the applied changes?
* How can an individual change be applied to the data store?
* How can an individual change be unapplied or backed out?
* How can we store in the data store itself the status of an individual change?
* How can we check for, and if necessary, initialize the data store for recording the status of changes?

Status
------

Nothing works right now.  The first actual tool produced based on this framework will likely be "RevelationRedis", for managing changes applied to the Redis store.

License
-------

Revelation is distributed under the BSD-3 license.


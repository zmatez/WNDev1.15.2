package com.matez.wildnature.world.gen.noise;

public class ModuleBase
{

   // base class for noise modules.
   public ModuleBase[] sourceModules;
   public int modulesRequired;

   public ModuleBase()
   {
      modulesRequired = 0;   
   }

   public ModuleBase (int modulesRequired)
   {
      // Create an array of pointers to all source modules required by this
      // noise module.  Set these pointers to null.
      if(modulesRequired>0)
      {
         sourceModules = new ModuleBase[modulesRequired];
         for (int i = 0; i < modulesRequired; i++)
         {
            sourceModules[i] = new ModuleBase();
         }
      }
      else
         sourceModules = null;

      this.modulesRequired = modulesRequired;
   }

   /// Returns a reference to a source module connected to this noise
   /// module.
   ///
   /// @param index The index value assigned to the source module.
   ///
   /// @returns A reference to the source module.
   ///
   /// @pre The index value ranges from 0 to one less than the number of
   /// source modules required by this noise module.
   /// @pre A source module with the specified index value has been added
   /// to this noise module via a call to setSourceModule().
   ///
   /// @throw ExceptionNoModule See the preconditions for more
   /// information.
   ///
   /// Each noise module requires the attachment of a certain number of
   /// source modules before an application can call the getValue()
   /// method.
   public ModuleBase getSourceModule (int index) throws NullPointerException
   {
      if (sourceModules != null)
      {
         if (index >= getSourceModuleCount () || index < 0
               || sourceModules[index] == null)
         {
            throw new NullPointerException ("Could not retrieve a source module " +
            "from a noise module.");
         }

         return (sourceModules[index]);
      }
      throw new NullPointerException ("Could not retrieve a source module " +
      "from a noise module.");
   }

   /// Returns the number of source modules required by this noise
   /// module.
   ///
   /// @returns The number of source modules required by this noise
   /// module.
   public int getSourceModuleCount()
   {
      return modulesRequired;
   }

   /// Generates an output value given the coordinates of the specified
   /// input value.
   ///
   /// @param x The @a x coordinate of the input value.
   /// @param y The @a y coordinate of the input value.
   /// @param z The @a z coordinate of the input value.
   ///
   /// @returns The output value.
   ///
   /// @pre All source modules required by this noise module have been
   /// passed to the setSourceModule() method.
   ///
   /// Before an application can call this method, it must first connect
   /// all required source modules via the setSourceModule() method.  If
   /// these source modules are not connected to this noise module, this
   /// method raises a debug assertion.
   ///
   /// To determine the number of source modules required by this noise
   /// module, call the getSourceModuleCount() method.
   public double getValue (double x, double y, double z)
   {
      return x;
   }

   /// Connects a source module to this noise module.
   ///
   /// @param index An index value to assign to this source module.
   /// @param sourceModule The source module to attach.
   ///
   /// @pre The index value ranges from 0 to one less than the number of
   /// source modules required by this noise module.
   ///
   /// @throw ExceptionInvalidParam An invalid parameter was
   /// specified; see the preconditions for more information.
   ///
   /// A noise module mathematically combines the output values from the
   /// source modules to generate the value returned by getValue().
   ///
   /// The index value to assign a source module is a unique identifier
   /// for that source module.  If an index value has already been
   /// assigned to a source module, this noise module replaces the old
   /// source module with the new source module.
   ///
   /// Before an application can call the getValue() method, it must
   /// first connect all required source modules.  To determine the
   /// number of source modules required by this noise module, call the
   /// getSourceModuleCount() method.
   ///
   /// This source module must exist throughout the lifetime of this
   /// noise module unless another source module replaces that source
   /// module.
   ///
   /// A noise module does not modify a source module; it only modifies
   /// its output values.
   public void setSourceModule (int index, ModuleBase sourceModule)
   throws NullPointerException
   {
      if (sourceModules != null)
      {
         if (index >= getSourceModuleCount () || index < 0)
            throw new NullPointerException ("Invalid Parameter in ModuleBase");
      }
      this.sourceModules[index] = sourceModule;
   }

}
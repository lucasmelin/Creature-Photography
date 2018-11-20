#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File name: test_creatures.py
Author: Lucas Melin
Date created: Nov 20, 2018
Date last modified: Nov 20, 2018
Python version: 3.7

This file contains tests of the Creatures base type and its sub types.
"""
from unittest import TestCase

from actors import Creature, Human, SmallAnimal, CamouflagedAnimal


class TestCreatures(TestCase):

    def test_human_is_creature(self):
        """
        Verify that a Human is also of type Creature.
        Lucas Melin
        """
        human = Human("Joe", 1)
        self.assertTrue(isinstance(human, Creature))

    def test_human_has_name(self):
        """
        Verify that a Human inherits the `name` field from Creature
        """
        human = Human("Frank", 1)
        self.assertEqual(human.name, "Frank")

    def test_small_animal_is_creature(self):
        """
        Verify that a SmallAnimal is also of type Creature.
        """
        small_animal = SmallAnimal("Guinea pig", 12)
        self.assertTrue(isinstance(small_animal, Creature))

    def test_small_animal_has_name(self):
        """
        Verify that a SmallAnimal inherits the `name` field from Creature
        """
        small_animal = SmallAnimal("Chinchilla", 8)
        self.assertEqual(small_animal.name, "Chinchilla")

    def test_camouflaged_animal_is_creature(self):
        """
        Verify that a CamouflagedAnimal is also of type Creature.
        """
        camouflaged_animal = CamouflagedAnimal("Deer", 20, 2, False)
        self.assertTrue(isinstance(camouflaged_animal, Creature))

    def test_camouflaged_animal_has_name(self):
        """
        Verify that a CamouflagedAnimal inherits the `name` field from Creature
        """
        camouflaged_animal = CamouflagedAnimal("Deer", 20, 2, False)
        self.assertEqual(camouflaged_animal.name, "Deer")


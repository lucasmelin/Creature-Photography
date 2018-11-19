import random


class Human:
    def __init__(self, name, speed):
        self.name = name
        self.speed = speed

    def photograph(self, creature):
        print("{} attempts to photograph {}".format(self.name, creature.name))

        shutter_speed = random.randint(1, 20) * self.speed
        evasion_speed = random.randint(1, 20) * creature.speed

        print('You snap a picture with a speed of {}'.format(self.speed))
        print('{} runs away with a speed of {}'.format(creature.name, creature.speed))

        if shutter_speed >= evasion_speed:
            print('You check your camera, and you have a clear picture of the {}!'.format(creature.name))
            return True
        else:
            print('You check your camera, but the picture is blurry.')
            return False


class Creature:
    def __init__(self, name, speed):
        self.name = name
        self.speed = speed

    def __repr__(self):
        return 'Creature {} with a speed of {}'.format(self.name, self.speed)
